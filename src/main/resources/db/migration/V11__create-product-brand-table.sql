CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE product_brand (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  product_id UUID NOT NULL,
  brand_id UUID NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(id),
  FOREIGN KEY (brand_id) REFERENCES brand(id)
);