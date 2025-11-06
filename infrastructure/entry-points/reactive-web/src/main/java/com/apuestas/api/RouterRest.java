package com.apuestas.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(POST("/api/bets"), handler::placeBet)
                .andRoute(GET("/api/users/{userId}/bets"), handler::getUserBets)
                .andRoute(GET("/api/matches/{matchId}/odds/stream"), handler::getOddsStream);
    }
}
