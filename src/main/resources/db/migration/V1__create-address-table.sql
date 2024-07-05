CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INTEGER,
    district VARCHAR(255),
    additional TEXT,
    code BIGINT
);