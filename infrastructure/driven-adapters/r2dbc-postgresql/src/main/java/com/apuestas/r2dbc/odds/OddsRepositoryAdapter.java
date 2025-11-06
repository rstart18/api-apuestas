package com.apuestas.r2dbc.odds;

import com.apuestas.model.odds.Odds;
import com.apuestas.model.odds.gateways.OddsRepository;
import com.apuestas.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class OddsRepositoryAdapter extends ReactiveAdapterOperations<Odds, OddsData, String, OddsReactiveRepository>
        implements OddsRepository {

    public OddsRepositoryAdapter(OddsReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Odds.class));
    }

    @Override
    public Flux<Odds> findByMatchId(String matchId) {
        return repository.findByMatchId(matchId)
                .map(this::toEntity);
    }

    @Override
    public Mono<Odds> findByMatchAndMarketAndSelection(String matchId, String market, String selection) {
        return repository.findByMatchIdAndMarketAndSelection(matchId, market, selection)
                .map(this::toEntity);
    }
}
