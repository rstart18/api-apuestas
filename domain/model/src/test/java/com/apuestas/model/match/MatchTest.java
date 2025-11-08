package com.apuestas.model.match;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void shouldCreateMatchWithBuilder() {
        // Given
        LocalDateTime startTime = LocalDateTime.now().plusHours(2);
        
        // When
        Match match = Match.builder()
                .id("match123")
                .homeTeam("Real Madrid")
                .awayTeam("Barcelona")
                .startTime(startTime)
                .status(Match.MatchStatus.SCHEDULED)
                .build();
        
        // Then
        assertEquals("match123", match.getId());
        assertEquals("Real Madrid", match.getHomeTeam());
        assertEquals("Barcelona", match.getAwayTeam());
        assertEquals(startTime, match.getStartTime());
        assertEquals(Match.MatchStatus.SCHEDULED, match.getStatus());
    }

    @Test
    void shouldReturnFalseWhenMatchIsScheduled() {
        // Given
        Match match = Match.builder()
                .status(Match.MatchStatus.SCHEDULED)
                .build();
        
        // When & Then
        assertFalse(match.hasStarted());
    }

    @Test
    void shouldReturnTrueWhenMatchIsLive() {
        // Given
        Match match = Match.builder()
                .status(Match.MatchStatus.LIVE)
                .build();
        
        // When & Then
        assertTrue(match.hasStarted());
    }

    @Test
    void shouldReturnTrueWhenMatchIsFinished() {
        // Given
        Match match = Match.builder()
                .status(Match.MatchStatus.FINISHED)
                .build();
        
        // When & Then
        assertTrue(match.hasStarted());
    }
}
