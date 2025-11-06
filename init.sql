-- Crear tablas
CREATE TABLE IF NOT EXISTS matches (
    id VARCHAR(255) PRIMARY KEY,
    home_team VARCHAR(255) NOT NULL,
    away_team VARCHAR(255) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'SCHEDULED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS odds (
    id VARCHAR(255) PRIMARY KEY,
    match_id VARCHAR(255) NOT NULL,
    market VARCHAR(100) NOT NULL,
    selection VARCHAR(100) NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (match_id) REFERENCES matches(id)
);

CREATE TABLE IF NOT EXISTS bets (
    id VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    match_id VARCHAR(255) NOT NULL,
    market VARCHAR(100) NOT NULL,
    selection VARCHAR(100) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    odds DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (match_id) REFERENCES matches(id)
);

-- Insertar datos de prueba
INSERT INTO matches (id, home_team, away_team, start_time, status) VALUES 
('match456', 'Real Madrid', 'Barcelona', '2025-11-06 15:00:00', 'SCHEDULED'),
('match789', 'Manchester United', 'Liverpool', '2025-11-06 17:30:00', 'SCHEDULED'),
('match101', 'Bayern Munich', 'Borussia Dortmund', '2025-11-07 14:00:00', 'SCHEDULED');

INSERT INTO odds (id, match_id, market, selection, value, active) VALUES 
-- Real Madrid vs Barcelona
('odds001', 'match456', '1X2', 'HOME', 2.50, TRUE),
('odds002', 'match456', '1X2', 'DRAW', 3.20, TRUE),
('odds003', 'match456', '1X2', 'AWAY', 2.80, TRUE),
('odds004', 'match456', 'TOTAL_GOALS', 'OVER_2_5', 1.85, TRUE),
('odds005', 'match456', 'TOTAL_GOALS', 'UNDER_2_5', 1.95, TRUE),

-- Manchester United vs Liverpool  
('odds006', 'match789', '1X2', 'HOME', 3.10, TRUE),
('odds007', 'match789', '1X2', 'DRAW', 3.40, TRUE),
('odds008', 'match789', '1X2', 'AWAY', 2.20, TRUE),

-- Bayern Munich vs Borussia Dortmund
('odds009', 'match101', '1X2', 'HOME', 1.90, TRUE),
('odds010', 'match101', '1X2', 'DRAW', 3.60, TRUE),
('odds011', 'match101', '1X2', 'AWAY', 4.20, TRUE);
