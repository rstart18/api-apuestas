package com.apuestas.api;

import com.apuestas.usecase.placebet.PlaceBetUseCase;
import com.apuestas.usecase.getuserbets.GetUserBetsUseCase;
import com.apuestas.usecase.getoddsstream.GetOddsStreamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class Handler {
    
    private final PlaceBetUseCase placeBetUseCase;
    private final GetUserBetsUseCase getUserBetsUseCase;
    private final GetOddsStreamUseCase getOddsStreamUseCase;

    public Mono<ServerResponse> placeBet(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PlaceBetRequest.class)
                .flatMap(request -> placeBetUseCase.execute(
                        request.getUserId(),
                        request.getMatchId(),
                        request.getMarket(),
                        request.getSelection(),
                        request.getAmount(),
                        request.getExpectedOdds()
                ))
                .flatMap(bet -> ServerResponse.ok().bodyValue(bet))
                .onErrorResume(throwable -> 
                    ServerResponse.badRequest().bodyValue(throwable.getMessage())
                );
    }

    public Mono<ServerResponse> getUserBets(ServerRequest serverRequest) {
        String userId = serverRequest.pathVariable("userId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getUserBetsUseCase.execute(userId), Object.class);
    }

    public Mono<ServerResponse> getOddsStream(ServerRequest serverRequest) {
        String matchId = serverRequest.pathVariable("matchId");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(getOddsStreamUseCase.execute(matchId), Object.class);
    }
    
    // DTO para el request de crear apuesta
    public static class PlaceBetRequest {
        private String userId;
        private String matchId;
        private String market;
        private String selection;
        private BigDecimal amount;
        private BigDecimal expectedOdds;
        
        // Getters y setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        
        public String getMatchId() { return matchId; }
        public void setMatchId(String matchId) { this.matchId = matchId; }
        
        public String getMarket() { return market; }
        public void setMarket(String market) { this.market = market; }
        
        public String getSelection() { return selection; }
        public void setSelection(String selection) { this.selection = selection; }
        
        public BigDecimal getAmount() { return amount; }
        public void setAmount(BigDecimal amount) { this.amount = amount; }
        
        public BigDecimal getExpectedOdds() { return expectedOdds; }
        public void setExpectedOdds(BigDecimal expectedOdds) { this.expectedOdds = expectedOdds; }
    }
}
