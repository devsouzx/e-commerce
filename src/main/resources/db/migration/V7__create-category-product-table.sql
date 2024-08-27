CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE category_product (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  product_id UUID NOT NULL,
  category_id UUID NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);