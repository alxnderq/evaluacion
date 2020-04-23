INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('hans','$2a$10$EaI4cMTOozQorL8BLWwgOOrZXDxKehWGLDtdauv.HxCRf65Ni51d.',1, 'Hans', 'Herrera','hans@bcp.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$7nqZn9gcVEb68w7e0vRSK.nyvXghhKJDKd.1bM4WKJmG7XOlhcPUi',1, 'Admin', 'Admin','admin@bcp.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

INSERT INTO `moneda` (descripcion, tipo_cambio) VALUES ('USD', '3.433');
INSERT INTO `moneda` (descripcion, tipo_cambio) VALUES ('EUR', '4.433');

INSERT INTO `currency` (currency_base) VALUES('PEN');
INSERT INTO `currency` (currency_base) VALUES('USD');
INSERT INTO `currency` (currency_base) VALUES('EUR');

INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('USD', '0.29', 1);
INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('EUR', '0.27', 1);

INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('PEN', '3.41', 2);
INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('EUR', '0.92', 2);

INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('PEN', '3.68', 3);
INSERT INTO `rates` (rate, exchange_rate, currency_id) VALUES('USD', '1.08', 3);
