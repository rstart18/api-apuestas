package com.apuestas.model.match;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Match {
    private String id;
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime startTime;
    private MatchStatus status;
    
    public enum MatchStatus {
        SCHEDULED, LIVE, FINISHED, CANCELLED
    }
    
    public boolean hasStarted() {
        return status == MatchStatus.LIVE || status == MatchStatus.FINISHED;
    }
}
