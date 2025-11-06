package com.apuestas.r2dbc.bet;

import com.apuestas.model.bet.Bet;
import com.apuestas.model.bet.gateways.BetRepository;
import com.apuestas.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BetRepositoryAdapter extends ReactiveAdapterOperations<Bet, BetData, String, BetReactiveRepository>
        implements BetRepository {

    public BetRepositoryAdapter(BetReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Bet.class));
    }

    @Override
    public Mono<Bet> save(Bet bet) {
        return repository.save(toData(bet))
                .map(this::toEntity);
    }

    @Override
    public Flux<Bet> findByUserId(String userId) {
        return repository.findByUserId(userId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Bet> findById(String id) {
        return repository.findById(id)
                .map(this::toEntity);
    }
}
