CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS tb_product(
    id_product      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name            VARCHAR,
    price           BIGINT,
    description     VARCHAR,
    imageUri        TEXT
);

CREATE TABLE IF NOT EXISTS tb_order(
    id_order            uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    address             VARCHAR,
    latitude            VARCHAR,
    longitude           VARCHAR,
    moment              TIMESTAMP,
    status              SMALLINT,
    total               BIGINT
);

CREATE TABLE IF NOT EXISTS tb_order_status(
    status SMALLINT
);

CREATE TABLE IF NOT EXISTS tb_order_product(
    id_order            uuid,
    id_product          uuid
);

ALTER TABLE tb_order_product
    ADD CONSTRAINT fk_id_order FOREIGN KEY (id_order) REFERENCES tb_order(id_order);

ALTER TABLE tb_order_product
    ADD CONSTRAINT fk_id_product FOREIGN KEY (id_product) REFERENCES tb_product(id_product);
