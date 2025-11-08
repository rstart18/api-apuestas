package com.apuestas.model.odds;
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
public class Odds {
    private String id;
    private String matchId;
    private String market;
    private String selection;
    private BigDecimal value;
    private LocalDateTime updatedAt;
    private boolean active;
}
