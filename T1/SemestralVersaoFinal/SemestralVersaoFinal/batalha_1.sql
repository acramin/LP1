
CREATE DATABASE batalha_naval;

CREATE USER 'Batalha'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON batalha_naval.* TO 'Batalha'@'localhost';

FLUSH PRIVILEGES;
