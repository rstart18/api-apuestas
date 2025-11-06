# Scripts para Crear Datos de Prueba

## 1. Crear Apuestas de Prueba

### Apuesta 1 - Real Madrid vs Barcelona
```json
POST /api/bets
{
  "userId": "user123",
  "matchId": "match456", 
  "market": "1X2",
  "selection": "HOME",
  "amount": 100.00,
  "expectedOdds": 2.50
}
```

### Apuesta 2 - Over/Under
```json
POST /api/bets
{
  "userId": "user123",
  "matchId": "match456",
  "market": "TOTAL_GOALS", 
  "selection": "OVER_2_5",
  "amount": 50.00,
  "expectedOdds": 1.85
}
```

### Apuesta 3 - Otro usuario
```json
POST /api/bets
{
  "userId": "user456",
  "matchId": "match789",
  "market": "1X2",
  "selection": "AWAY", 
  "amount": 75.00,
  "expectedOdds": 3.20
}
```

## 2. Verificar Datos Creados

```
GET /api/users/user123/bets
GET /api/users/user456/bets
```
