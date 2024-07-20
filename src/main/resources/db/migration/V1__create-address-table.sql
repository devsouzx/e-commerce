CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    street_name VARCHAR(255) NOT NULL,
    street_number INTEGER,
    district VARCHAR(255),
    additional TEXT,
    zip_code VARCHAR(10),
    address_type VARCHAR(50)
);