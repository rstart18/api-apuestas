package com.apuestas.model.bethistory;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BetHistory {
    private String id;
    private String userId;
    private String betId;
    private String matchId;
    private String market;
    private String selection;
    private BigDecimal amount;
    private BigDecimal odds;
    private BetStatus status;
    private BigDecimal payout;
    private LocalDateTime betDate;
    private LocalDateTime settledDate;
    
    public enum BetStatus {
        PENDING, WON, LOST, CANCELLED
    }
}
