----------------------------------------------
-- Username: mequiroga - password: 1234     --
-- Username: andif912 - password: argentina --
----------------------------------------------
INSERT INTO user (username, password) VALUES ('mequiroga', '$2a$10$3Vn4fgM11M4Lj1Ncy4X/5.KCHOIWB/cgRlOOHFxE885KtqDRu2sYC');
INSERT INTO user (username, password) VALUES ('andif912', '$2a$10$pN8gXOeZATUBMD7ccN/Jyu/18gWuz6P5lELLtUKZTxXMcaLMSVLza');

INSERT INTO rol (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO rol (role_name) VALUES ('ROLE_USER');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

INSERT INTO personal_information (id, about, banner_image, lastname, mail, name, phone, profile_image, title, ubication, user_id) VALUES (NULL, 'Hola! Soy Emanuel, estudiante de Desarrollador Web Full Stack, un curso creado por el Ministerio de Desarrollo Productivo de Argentina. ', 'https://serving.photos.photobox.com/5452879570c8379f0043349add9b79895419734f797da184c8e0d7b2fabafee406656ba7.jpg', 'Quiroga', 'quirogatdf@gmail.com', 'Marcelo Emanuel', '1232131', 'https://i.pinimg.com/originals/74/aa/12/74aa122cc4c839fe08967cfddb6a158d.jpg', 'Desarrollador Web Fullstack Jr', 'Río Grande, Tierra del Fuego', 1);