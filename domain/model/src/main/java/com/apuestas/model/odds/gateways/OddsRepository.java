package com.apuestas.model.odds.gateways;

import com.apuestas.model.odds.Odds;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OddsRepository {
    Mono<Odds> findByMatchAndMarketAndSelection(String matchId, String market, String selection);
    Flux<Odds> findByMatchId(String matchId);
    Mono<Odds> save(Odds odds);
}
