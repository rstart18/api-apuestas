#!/bin/bash

# Construir la imagen de PostgreSQL
docker build -f Dockerfile.postgres -t api-apuestas-postgres .

# Ejecutar el contenedor
docker run -d \
  --name api-apuestas-db \
  -p 5432:5432 \
  -v postgres_data:/var/lib/postgresql/data \
  api-apuestas-postgres

echo "Base de datos PostgreSQL iniciada en puerto 5432"
echo "Conexión: postgresql://postgres:secret@localhost:5432/apuestas"
