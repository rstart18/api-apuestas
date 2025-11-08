package com.apuestas.usecase.getuserbets;

import com.apuestas.model.bet.Bet;
import com.apuestas.model.bet.gateways.BetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserBetsUseCaseTest {

    @Mock
    private BetRepository betRepository;

    private GetUserBetsUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new GetUserBetsUseCase(betRepository);
    }

    @Test
    void shouldReturnUserBetsSortedByDate() {
        // Given
        String userId = "user123";
        LocalDateTime now = LocalDateTime.now();
        
        Bet bet1 = Bet.builder()
                .id("bet1")
                .userId(userId)
                .createdAt(now.minusHours(2))
                .build();
                
        Bet bet2 = Bet.builder()
                .id("bet2")
                .userId(userId)
                .createdAt(now.minusHours(1))
                .build();

        when(betRepository.findByUserId(userId))
                .thenReturn(Flux.just(bet1, bet2));

        // When & Then
        StepVerifier.create(useCase.execute(userId))
                .expectNext(bet2) // Más reciente primero
                .expectNext(bet1)
                .verifyComplete();
    }

    @Test
    void shouldReturnEmptyWhenUserHasNoBets() {
        // Given
        String userId = "user999";
        when(betRepository.findByUserId(userId))
                .thenReturn(Flux.empty());

        // When & Then
        StepVerifier.create(useCase.execute(userId))
                .verifyComplete();
    }
}
