package com.apuestas.usecase.getuserbets;

import com.apuestas.model.bet.Bet;
import com.apuestas.model.bet.gateways.BetRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetUserBetsUseCase {
    
    private final BetRepository betRepository;
    
    public Flux<Bet> execute(String userId) {
        return betRepository.findByUserId(userId)
            .sort((bet1, bet2) -> bet2.getCreatedAt().compareTo(bet1.getCreatedAt())) // Más recientes primero
            .doOnNext(bet -> System.out.println("Recuperando apuesta: " + bet.getId() + " para usuario: " + userId));
    }
}
