package com.apuestas.model.bethistory.gateways;

import com.apuestas.model.bethistory.BetHistory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BetHistoryRepository {
    Mono<BetHistory> save(BetHistory betHistory);
    Flux<BetHistory> findByUserId(String userId);
    Mono<BetHistory> findById(String id);
}
