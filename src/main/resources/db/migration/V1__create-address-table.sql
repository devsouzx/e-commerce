CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    number INTEGER NOT NULL,
    district VARCHAR(100) NOT NULL,
    additional VARCHAR(100),
    code BIGINT NOT NULL
);