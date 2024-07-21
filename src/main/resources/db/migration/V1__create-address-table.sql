CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    street VARCHAR(255) NOT NULL,
    number INTEGER,
    district VARCHAR(255),
    additional TEXT,
    zip_code VARCHAR(10)
);