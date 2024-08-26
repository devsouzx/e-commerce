CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    avatar_url VARCHAR(255),
    birth_date DATE,
    created_at TIMESTAMP,
    email VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    role VARCHAR(50)
);