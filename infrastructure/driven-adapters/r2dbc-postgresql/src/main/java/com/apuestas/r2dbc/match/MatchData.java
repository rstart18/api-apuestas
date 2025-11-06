package com.apuestas.r2dbc.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("matches")
public class MatchData {
    
    @Id
    private String id;
    
    @Column("home_team")
    private String homeTeam;
    
    @Column("away_team")
    private String awayTeam;
    
    @Column("start_time")
    private LocalDateTime startTime;
    
    private String status;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
}
