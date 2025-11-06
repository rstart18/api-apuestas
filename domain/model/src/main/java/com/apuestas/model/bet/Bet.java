package com.apuestas.model.bet;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Bet {
    private String id;
    private String userId;
    private String matchId;
    private String market;
    private String selection;
    private BigDecimal amount;
    private BigDecimal odds;
    private BetStatus status;
    private LocalDateTime createdAt;
    
    public enum BetStatus {
        PENDING, WON, LOST, CANCELLED
    }
}
