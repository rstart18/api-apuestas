package com.apuestas.r2dbc.odds;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OddsReactiveRepository extends ReactiveCrudRepository<OddsData, String>, ReactiveQueryByExampleExecutor<OddsData> {
    
    Flux<OddsData> findByMatchId(String matchId);
    
    Mono<OddsData> findByMatchIdAndMarketAndSelection(String matchId, String market, String selection);
}
