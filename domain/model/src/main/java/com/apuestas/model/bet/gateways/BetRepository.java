package com.apuestas.model.bet.gateways;

import com.apuestas.model.bet.Bet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BetRepository {
    Mono<Bet> save(Bet bet);
    Flux<Bet> findByUserId(String userId);
    Mono<Bet> findById(String id);
}
