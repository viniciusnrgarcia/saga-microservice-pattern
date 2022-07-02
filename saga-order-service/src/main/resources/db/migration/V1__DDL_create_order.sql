CREATE TABLE IF NOT EXISTS order.order_type (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	order_type_description varchar(255)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS order.order_state (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	order_state_description varchar(255)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS order.order (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	order_type INT,
	order_description varchar(255) ,
	order_value DECIMAL(15, 2) ,
	order_state INT ,
	product_id varchar(255),
	product_items int,
    product_description varchar(255),
    customer_id varchar(255),
    user_created varchar(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_updated varchar(255),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;
