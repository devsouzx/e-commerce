CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE product_image (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  product_id UUID NOT NULL,
  image_url TEXT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(id)
);