package com.apuestas.r2dbc.bet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("bets")
public class BetData {
    
    @Id
    private String id;
    private String userId;
    private String matchId;
    private String market;
    private String selection;
    private BigDecimal amount;
    private BigDecimal odds;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
