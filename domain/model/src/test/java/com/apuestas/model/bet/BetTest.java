package com.apuestas.model.bet;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BetTest {

    @Test
    void shouldCreateBetWithBuilder() {
        // Given
        LocalDateTime now = LocalDateTime.now();
        
        // When
        Bet bet = Bet.builder()
                .id("bet123")
                .userId("user123")
                .matchId("match456")
                .market("1X2")
                .selection("HOME")
                .amount(new BigDecimal("100.00"))
                .odds(new BigDecimal("2.50"))
                .status(Bet.BetStatus.PENDING)
                .createdAt(now)
                .build();
        
        // Then
        assertEquals("bet123", bet.getId());
        assertEquals("user123", bet.getUserId());
        assertEquals("match456", bet.getMatchId());
        assertEquals("1X2", bet.getMarket());
        assertEquals("HOME", bet.getSelection());
        assertEquals(new BigDecimal("100.00"), bet.getAmount());
        assertEquals(new BigDecimal("2.50"), bet.getOdds());
        assertEquals(Bet.BetStatus.PENDING, bet.getStatus());
        assertEquals(now, bet.getCreatedAt());
    }

    @Test
    void shouldCreateBetWithNoArgsConstructor() {
        // When
        Bet bet = new Bet();
        
        // Then
        assertNotNull(bet);
        assertNull(bet.getId());
        assertNull(bet.getStatus());
    }

    @Test
    void shouldSetAndGetProperties() {
        // Given
        Bet bet = new Bet();
        
        // When
        bet.setId("bet456");
        bet.setStatus(Bet.BetStatus.WON);
        bet.setAmount(new BigDecimal("50.00"));
        
        // Then
        assertEquals("bet456", bet.getId());
        assertEquals(Bet.BetStatus.WON, bet.getStatus());
        assertEquals(new BigDecimal("50.00"), bet.getAmount());
    }
}
