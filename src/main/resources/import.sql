INSERT INTO user (name, email, password) VALUES ('User1', 'user1@gmail.com', '$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK');

INSERT INTO user (name, email, password) VALUES ('User2', 'user2@gmail.com', '$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK');

INSERT INTO user (name, email, password) VALUES ('User3', 'user3@gmail.com', '$2a$10$3Qrx0rv8qSmZ8s3RlD5qE.upleP7.Qzbg5EoIAm62evEkY4c023TK');

INSERT INTO role (authority) VALUES ('ROLE_USUARIO_CADASTRO');

INSERT INTO user_roles (user_id, roles_authority) VALUES (1, 'ROLE_USUARIO_CADASTRO');