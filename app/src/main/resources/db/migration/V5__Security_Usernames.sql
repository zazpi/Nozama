INSERT INTO users(username,password,enabled) VALUES ('lucas','lucas', true);
INSERT INTO users(username,password,enabled) VALUES ('hodei','hodei', true);
INSERT INTO users(username,password,enabled) VALUES ('asier','asier', true);
INSERT INTO users(username,password,enabled) VALUES ('bingen','bingen', true);
 
INSERT INTO user_roles (username, role) VALUES ('lucas', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('lucas', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('hodei', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('asier', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('bingen', 'ROLE_USER');
