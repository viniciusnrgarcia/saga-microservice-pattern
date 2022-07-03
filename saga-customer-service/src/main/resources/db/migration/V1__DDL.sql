CREATE TABLE IF NOT EXISTS customer.tb_customer_status (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_status INT NOT NULL,
	customer_status_description varchar(255)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS customer.tb_customer (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) NOT NULL,
    password varchar(20) NOT NULL,
    name varchar(100) NOT NULL,
    customer_status INT NOT NULL,
    user_created varchar(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_updated varchar(255),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) engine=InnoDB;
