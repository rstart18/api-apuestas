package com.apuestas.r2dbc.bet;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BetReactiveRepository extends ReactiveCrudRepository<BetData, String>, ReactiveQueryByExampleExecutor<BetData> {
    
    Flux<BetData> findByUserId(String userId);
}
