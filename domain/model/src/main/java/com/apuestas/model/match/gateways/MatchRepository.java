package com.apuestas.model.match.gateways;

import com.apuestas.model.match.Match;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MatchRepository {
    Mono<Match> findById(String id);
    Flux<Match> findAll();
    Mono<Match> save(Match match);
}
