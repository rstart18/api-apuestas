# API Apuestas - Ejemplos de Requests

## 🎯 Realizar Apuesta
**POST** `/api/bets`

```json
{
  "userId": "user123",
  "matchId": "match456",
  "market": "1X2",
  "selection": "HOME",
  "amount": 100.00,
  "expectedOdds": 2.50
}
```

### Ejemplos de diferentes mercados:
```json
// Apuesta Over/Under
{
  "userId": "user123",
  "matchId": "match456", 
  "market": "TOTAL_GOALS",
  "selection": "OVER_2_5",
  "amount": 50.00,
  "expectedOdds": 1.85
}

// Apuesta Handicap
{
  "userId": "user123",
  "matchId": "match456",
  "market": "HANDICAP",
  "selection": "HOME_-1",
  "amount": 75.00,
  "expectedOdds": 3.20
}
```

## 📊 Obtener Apuestas de Usuario
**GET** `/api/users/{userId}/bets`

Ejemplo: `GET /api/users/user123/bets`

**Response esperado:**
```json
[
  {
    "id": "bet001",
    "userId": "user123",
    "matchId": "match456",
    "market": "1X2",
    "selection": "HOME",
    "amount": 100.00,
    "odds": 2.50,
    "status": "PENDING",
    "createdAt": "2025-11-05T20:30:00"
  }
]
```

## 📡 Stream de Cuotas en Tiempo Real
**GET** `/api/matches/{matchId}/odds/stream`

Ejemplo: `GET /api/matches/match456/odds/stream`

**Headers requeridos:**
```
Accept: text/event-stream
```

**Response esperado (Server-Sent Events):**
```
data: {"id":"odds001","matchId":"match456","market":"1X2","selection":"HOME","value":2.50,"active":true,"updatedAt":"2025-11-05T20:30:00"}

data: {"id":"odds002","matchId":"match456","market":"1X2","selection":"DRAW","value":3.20,"active":true,"updatedAt":"2025-11-05T20:30:00"}

data: {"id":"odds003","matchId":"match456","market":"1X2","selection":"AWAY","value":2.80,"active":true,"updatedAt":"2025-11-05T20:30:00"}
```

## 🔧 Variables de Entorno para Postman

```
baseUrl: http://localhost:8080
userId: user123
matchId: match456
```

## ⚠️ Posibles Errores

### 400 Bad Request - Saldo Insuficiente
```json
{
  "error": "Saldo insuficiente para realizar la apuesta"
}
```

### 400 Bad Request - Cuotas Cambiadas
```json
{
  "error": "Las cuotas han cambiado, por favor intenta nuevamente"
}
```

### 400 Bad Request - Partido Comenzado
```json
{
  "error": "No se pueden realizar apuestas, el partido ya comenzó"
}
```

## 🧪 Casos de Prueba Sugeridos

1. **Apuesta exitosa**: Usar los datos del ejemplo básico
2. **Cuotas cambiadas**: Intentar apostar con cuotas desactualizadas
3. **Monto excesivo**: Apostar más de $10,000
4. **Usuario inexistente**: Usar un userId que no existe
5. **Partido inexistente**: Usar un matchId que no existe
6. **Stream de cuotas**: Conectarse al stream y observar actualizaciones cada 2 segundos
