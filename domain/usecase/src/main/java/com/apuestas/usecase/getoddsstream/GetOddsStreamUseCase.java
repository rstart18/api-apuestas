package com.apuestas.usecase.getoddsstream;

import com.apuestas.model.odds.Odds;
import com.apuestas.model.odds.gateways.OddsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RequiredArgsConstructor
public class GetOddsStreamUseCase {
    
    private final OddsRepository oddsRepository;
    
    public Flux<Odds> execute(String matchId) {
        return Flux.interval(Duration.ofSeconds(2))
            .flatMap(tick -> oddsRepository.findByMatchId(matchId))
            .distinctUntilChanged(odds -> odds.getValue() + "_" + odds.getUpdatedAt())
            .filter(Odds::isActive)
            .doOnNext(odds -> System.out.println("Emitiendo cuotas actualizadas para partido: " + matchId));
    }
}
