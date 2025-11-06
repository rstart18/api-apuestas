package com.apuestas.usecase.placebet;

import com.apuestas.model.bet.Bet;
import com.apuestas.model.bet.gateways.BetRepository;
import com.apuestas.model.odds.gateways.OddsRepository;
import com.apuestas.model.match.gateways.MatchRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class PlaceBetUseCase {
    
    private final BetRepository betRepository;
    private final OddsRepository oddsRepository;
    private final MatchRepository matchRepository;
    
    public Mono<Bet> execute(String userId, String matchId, String market, 
                           String selection, BigDecimal amount, BigDecimal expectedOdds) {
        
        return Mono.zip(
            validateMatchNotStarted(matchId),
            validateOddsStillValid(matchId, market, selection, expectedOdds),
            validateUserBalance(userId, amount)
        )
        .flatMap(tuple -> {
            var currentOdds = tuple.getT2();
            return createAndSaveBet(userId, matchId, market, selection, amount, currentOdds.getValue());
        });
    }
    
    private Mono<Void> validateMatchNotStarted(String matchId) {
        return matchRepository.findById(matchId)
            .filter(match -> !match.hasStarted())
            .switchIfEmpty(Mono.error(new MatchAlreadyStartedException()))
            .then();
    }
    
    private Mono<com.apuestas.model.odds.Odds> validateOddsStillValid(String matchId, String market, 
                                                                     String selection, BigDecimal expectedOdds) {
        return oddsRepository.findByMatchAndMarketAndSelection(matchId, market, selection)
            .filter(odds -> odds.isActive())
            .filter(odds -> odds.getValue().equals(expectedOdds))
            .switchIfEmpty(Mono.error(new OddsChangedException()));
    }
    
    private Mono<Void> validateUserBalance(String userId, BigDecimal amount) {
        // Simulación - en implementación real consultaría servicio de balance
        return Mono.just(amount)
            .filter(amt -> amt.compareTo(BigDecimal.valueOf(10000)) <= 0) // Max $10,000
            .switchIfEmpty(Mono.error(new InsufficientBalanceException()))
            .then();
    }
    
    private Mono<Bet> createAndSaveBet(String userId, String matchId, String market,
                                     String selection, BigDecimal amount, BigDecimal odds) {
        Bet bet = Bet.builder()
            .userId(userId)
            .matchId(matchId)
            .market(market)
            .selection(selection)
            .amount(amount)
            .odds(odds)
            .status(Bet.BetStatus.PENDING)
            .createdAt(LocalDateTime.now())
            .build();
            
        return betRepository.save(bet);
    }
    
    public static class InsufficientBalanceException extends RuntimeException {
        public InsufficientBalanceException() {
            super("Saldo insuficiente para realizar la apuesta");
        }
    }
    
    public static class OddsChangedException extends RuntimeException {
        public OddsChangedException() {
            super("Las cuotas han cambiado, por favor intenta nuevamente");
        }
    }
    
    public static class MatchAlreadyStartedException extends RuntimeException {
        public MatchAlreadyStartedException() {
            super("No se pueden realizar apuestas, el partido ya comenzó");
        }
    }
}
