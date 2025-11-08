#!/bin/bash

# Instalar PostgreSQL
sudo apt update
sudo apt install -y postgresql postgresql-contrib

# Iniciar servicio
sudo systemctl start postgresql
sudo systemctl enable postgresql

# Crear base de datos y usuario
sudo -u postgres psql -c "CREATE DATABASE apuestas;"
sudo -u postgres psql -c "CREATE USER postgres WITH PASSWORD 'secret';"
sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE apuestas TO postgres;"

# Ejecutar script de inicialización si existe
if [ -f "init.sql" ]; then
    sudo -u postgres psql -d apuestas -f init.sql
fi

echo "PostgreSQL instalado y configurado"
echo "Conexión: postgresql://postgres:secret@localhost:5432/apuestas"
