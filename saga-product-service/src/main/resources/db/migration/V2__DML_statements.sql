INSERT INTO product.tb_product_state
       (id, product_state, product_state_description)
       values
       (1, 'AVAILABLE', 'Produto disponível em estoque'),
       (2, 'NOT_AVAILABLE', 'Produto sem estoque'),
       (3, 'PAUSED', 'Produto com anúncio pausado'),
       (4, 'REMOVED', 'Produto removido');

INSERT INTO product.tb_product
(product_items, product_value, product_description, user_created, user_updated)
VALUES(1000, 525.00, 'Corsair Carbide 175R', 'release1', 'release1');
INSERT INTO product.tb_product
(product_items, product_value, product_description, user_created, user_updated)
VALUES(500, 219.90, 'Mouse Razer Deeathadder', 'release1', 'release1');
INSERT INTO product.tb_product
(product_items, product_value, product_description, user_created, user_updated)
VALUES(200, 2094.00, 'AMD Ryzen 5600X', 'release1', 'release1');
INSERT INTO product.tb_product
(product_items, product_value, product_description, user_created, user_updated)
VALUES(500, 1999.00, 'Asus ROG Strix B550-F', 'release1', 'release1');
