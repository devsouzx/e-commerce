ALTER TABLE product
RENAME COLUMN brand TO brand_id;

ALTER TABLE product
ALTER COLUMN brand_id TYPE UUID USING brand_id::uuid;