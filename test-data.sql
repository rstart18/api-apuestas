-- Más partidos
INSERT INTO matches (id, home_team, away_team, start_time, status) VALUES 
('match201', 'Chelsea', 'Arsenal', '2025-11-08 16:00:00', 'SCHEDULED'),
('match202', 'PSG', 'Marseille', '2025-11-09 20:00:00', 'SCHEDULED'),
('match203', 'Juventus', 'AC Milan', '2025-11-10 18:30:00', 'LIVE'),
('match204', 'Atletico Madrid', 'Valencia', '2025-11-05 19:00:00', 'FINISHED');

-- Más cuotas
INSERT INTO odds (id, match_id, market, selection, value, active) VALUES 
-- Chelsea vs Arsenal
('odds012', 'match201', '1X2', 'HOME', 2.10, TRUE),
('odds013', 'match201', '1X2', 'DRAW', 3.30, TRUE),
('odds014', 'match201', '1X2', 'AWAY', 3.50, TRUE),
('odds015', 'match201', 'BOTH_TEAMS_SCORE', 'YES', 1.70, TRUE),
('odds016', 'match201', 'BOTH_TEAMS_SCORE', 'NO', 2.10, TRUE),

-- PSG vs Marseille
('odds017', 'match202', '1X2', 'HOME', 1.45, TRUE),
('odds018', 'match202', '1X2', 'DRAW', 4.50, TRUE),
('odds019', 'match202', '1X2', 'AWAY', 6.00, TRUE),
('odds020', 'match202', 'TOTAL_GOALS', 'OVER_3_5', 2.30, TRUE),

-- Juventus vs AC Milan
('odds021', 'match203', '1X2', 'HOME', 2.40, TRUE),
('odds022', 'match203', '1X2', 'DRAW', 3.10, TRUE),
('odds023', 'match203', '1X2', 'AWAY', 2.90, TRUE);

-- Apuestas de ejemplo
INSERT INTO bets (id, user_id, match_id, market, selection, amount, odds, status) VALUES 
('bet001', 'user123', 'match456', '1X2', 'HOME', 50.00, 2.50, 'PENDING'),
('bet002', 'user456', 'match456', 'TOTAL_GOALS', 'OVER_2_5', 25.00, 1.85, 'PENDING'),
('bet003', 'user789', 'match789', '1X2', 'AWAY', 100.00, 2.20, 'PENDING'),
('bet004', 'user123', 'match201', 'BOTH_TEAMS_SCORE', 'YES', 30.00, 1.70, 'PENDING'),
('bet005', 'user456', 'match204', '1X2', 'HOME', 75.00, 1.80, 'WON');
