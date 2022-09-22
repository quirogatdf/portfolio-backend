----------------------------------------------
-- Username: mequiroga - password: 1234     --
-- Username: andif912 - password: argentina --
----------------------------------------------
INSERT INTO user (username, password) VALUES ('mequiroga', '$2a$10$3Vn4fgM11M4Lj1Ncy4X/5.KCHOIWB/cgRlOOHFxE885KtqDRu2sYC');
INSERT INTO user (username, password) VALUES ('andif912', '$2a$10$pN8gXOeZATUBMD7ccN/Jyu/18gWuz6P5lELLtUKZTxXMcaLMSVLza');

INSERT INTO rol (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO rol (role_name) VALUES ('ROLE_USER');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUE (2,2);