CREATE DATABASE logins;

CREATE USER 'loginSenha'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON logins.* TO 'loginSenha'@'localhost';

USE logins;

CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) NOT NULL UNIQUE,   
    Password VARCHAR(255) NOT NULL);

INSERT INTO Users (Username, Password)
VALUES 
('Amanda', '1234'),
('admin', 'admin'),
('public', 'public'),
('Otto Camargo Kuchkarian', '1234'),
('André Felipe Xavier', '1234'),
('Rafael Assanti', '22.01464-0'),
('Rodrigo Faltz', '1234'),
('Calvetti', '1234');

FLUSH PRIVILEGES;
