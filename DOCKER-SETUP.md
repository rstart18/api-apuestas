# 🐳 Setup con Docker

## Pasos para ejecutar la API con PostgreSQL dockerizado

### 1. Levantar PostgreSQL
```bash
docker-compose up -d
```

### 2. Verificar que PostgreSQL esté corriendo
```bash
docker ps
```
Deberías ver el contenedor `api-apuestas-db` corriendo en puerto 5432.

### 3. Ejecutar la aplicación
```bash
./gradlew bootRun
```

### 4. Probar con Postman
La base de datos ya tendrá datos de prueba:
- **3 partidos** con IDs: match456, match789, match101
- **11 cuotas** para diferentes mercados
- **Tablas creadas** automáticamente

## Comandos útiles

### Ver logs de PostgreSQL
```bash
docker-compose logs postgres
```

### Conectarse a PostgreSQL
```bash
docker exec -it api-apuestas-db psql -U postgres -d apuestas
```

### Parar PostgreSQL
```bash
docker-compose down
```

### Parar y eliminar datos
```bash
docker-compose down -v
```

## Datos de prueba incluidos

### Partidos
- **match456**: Real Madrid vs Barcelona
- **match789**: Manchester United vs Liverpool  
- **match101**: Bayern Munich vs Borussia Dortmund

### Cuotas disponibles
- Mercado **1X2** (HOME/DRAW/AWAY)
- Mercado **TOTAL_GOALS** (OVER_2_5/UNDER_2_5)

¡Ahora la API funcionará perfectamente con PostgreSQL!
