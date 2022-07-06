CREATE TABLE IF NOT EXISTS product.tb_product_state (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_state varchar(255),
	product_state_description varchar(255)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS product.tb_product (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_items int,
    product_value DECIMAL(15, 2) ,
    product_description varchar(255),
    user_created varchar(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_updated varchar(255),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS product.tb_product_order (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_id varchar(255),
	product_items int,
    order_id BIGINT NOT NULL,
    order_value DECIMAL(15, 2) ,
    customer_id varchar(255),
    product_order_status INT,
    user_created varchar(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_updated varchar(255),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;
