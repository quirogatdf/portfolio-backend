INSERT INTO user (username, password) VALUES ('mequiroga', '1234');
INSERT INTO user (username, password) VALUES ('andif912', '1234');

INSERT INTO rol (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO rol (role_name) VALUES ('ROLE_USER');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);