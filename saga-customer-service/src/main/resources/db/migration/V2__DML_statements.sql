INSERT INTO customer.tb_customer_status
    (id, customer_status, customer_status_description)
    values
        (1, 1, 'Usuário Ativo'),
        (2, 2, 'Usuário Pendente'),
        (3, 3, 'Usuário Bloqueado'),
        (4, 4, 'Usuário Fechado');

INSERT INTO customer.tb_customer
       (username, password, name, customer_status, user_created, user_updated)
       values
        ('admin', '123', 'Administrador', 1, 'admin', 'admin');


