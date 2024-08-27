CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE product (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description TEXT,
  price DECIMAL(10, 2) NOT NULL,
  stock_quantity INTEGER,
  brand VARCHAR(100),
  category_id UUID NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);