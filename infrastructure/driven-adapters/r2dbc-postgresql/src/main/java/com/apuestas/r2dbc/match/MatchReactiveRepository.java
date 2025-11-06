package com.apuestas.r2dbc.match;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MatchReactiveRepository extends ReactiveCrudRepository<MatchData, String>, ReactiveQueryByExampleExecutor<MatchData> {
}
