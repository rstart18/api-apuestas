package com.apuestas.r2dbc.match;

import com.apuestas.model.match.Match;
import com.apuestas.model.match.gateways.MatchRepository;
import com.apuestas.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MatchRepositoryAdapter extends ReactiveAdapterOperations<Match, MatchData, String, MatchReactiveRepository>
        implements MatchRepository {

    public MatchRepositoryAdapter(MatchReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Match.class));
    }

    @Override
    public Mono<Match> findById(String id) {
        return repository.findById(id)
                .map(this::toEntity);
    }
}
