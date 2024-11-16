CREATE DATABASE batalha_naval;

CREATE USER 'login'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON batalha_naval.* TO 'login'@'localhost';

FLUSH PRIVILEGES;

USE batalha_naval;
CREATE TABLE `resultados_partidas` (
  `vitoria` tinyint(1) NOT NULL,
  `jogador` varchar(255) NOT NULL,
  `data_jogo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `User` varchar(50) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Wins` int DEFAULT NULL,
  UNIQUE KEY `User` (`User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `batalha_naval`.`users`
(`User`,`Password`,`Wins`)
VALUES
('Rafael',1234,0),('Amanda',1234,0),('Otto',1234,0),('Rodrigo',1234,0),('Andre',1234,0),('admin',1234,0),('Bigode',1234,0),('Player23',1234,0),('Player13',1234,0),('Player4',1234,0);

INSERT INTO `batalha_naval`.`resultados_partidas`
(`vitoria`, `jogador`, `data_jogo`)
VALUES
-- Week 1
(1, 'Rafael', '2024-11-12'), (0, 'Rafael', '2024-11-10'),
(1, 'Amanda', '2024-11-12'), (0, 'Amanda', '2024-11-10'),
(1, 'Otto', '2024-11-12'), (0, 'Otto', '2024-11-10'),
(1, 'Rodrigo', '2024-11-12'), (0, 'Rodrigo', '2024-11-10'),
(1, 'Andre', '2024-11-12'), (0, 'Andre', '2024-11-10'),
(1, 'admin', '2024-11-12'), (0, 'admin', '2024-11-10'),
(1, 'Bigode', '2024-11-12'), (0, 'Bigode', '2024-11-10'),
(1, 'Player23', '2024-11-12'), (0, 'Player23', '2024-11-10'),
(1, 'Player13', '2024-11-12'), (0, 'Player13', '2024-11-10'),
(1, 'Player4', '2024-11-12'), (0, 'Player4', '2024-11-10'),

-- Week 2
(1, 'Rafael', '2024-11-05'), (0, 'Rafael', '2024-11-03'),
(1, 'Amanda', '2024-11-05'), (0, 'Amanda', '2024-11-03'),
(1, 'Otto', '2024-11-05'), (0, 'Otto', '2024-11-03'),
(1, 'Rodrigo', '2024-11-05'), (0, 'Rodrigo', '2024-11-03'),
(1, 'Andre', '2024-11-05'), (0, 'Andre', '2024-11-03'),
(1, 'admin', '2024-11-05'), (0, 'admin', '2024-11-03'),
(1, 'Bigode', '2024-11-05'), (0, 'Bigode', '2024-11-03'),
(1, 'Player23', '2024-11-05'), (0, 'Player23', '2024-11-03'),
(1, 'Player13', '2024-11-05'), (0, 'Player13', '2024-11-03'),
(1, 'Player4', '2024-11-05'), (0, 'Player4', '2024-11-03'),

-- Week 3
(1, 'Rafael', '2024-10-29'), (0, 'Rafael', '2024-10-27'),
(1, 'Amanda', '2024-10-29'), (0, 'Amanda', '2024-10-27'),
(1, 'Otto', '2024-10-29'), (0, 'Otto', '2024-10-27'),
(1, 'Rodrigo', '2024-10-29'), (0, 'Rodrigo', '2024-10-27'),
(1, 'Andre', '2024-10-29'), (0, 'Andre', '2024-10-27'),
(1, 'admin', '2024-10-29'), (0, 'admin', '2024-10-27'),
(1, 'Bigode', '2024-10-29'), (0, 'Bigode', '2024-10-27'),
(1, 'Player23', '2024-10-29'), (0, 'Player23', '2024-10-27'),
(1, 'Player13', '2024-10-29'), (0, 'Player13', '2024-10-27'),
(1, 'Player4', '2024-10-29'), (0, 'Player4', '2024-10-27'),

-- Week 4
(1, 'Rafael', '2024-10-22'), (0, 'Rafael', '2024-10-20'),
(1, 'Amanda', '2024-10-22'), (0, 'Amanda', '2024-10-20'),
(1, 'Otto', '2024-10-22'), (0, 'Otto', '2024-10-20'),
(1, 'Rodrigo', '2024-10-22'), (0, 'Rodrigo', '2024-10-20'),
(1, 'Andre', '2024-10-22'), (0, 'Andre', '2024-10-20'),
(1, 'admin', '2024-10-22'), (0, 'admin', '2024-10-20'),
(1, 'Bigode', '2024-10-22'), (0, 'Bigode', '2024-10-20'),
(1, 'Player23', '2024-10-22'), (0, 'Player23', '2024-10-20'),
(1, 'Player13', '2024-10-22'), (0, 'Player13', '2024-10-20'),
(1, 'Player4', '2024-10-22'), (0, 'Player4', '2024-10-20'),

-- Week 5
(1, 'Rafael', '2024-10-15'), (0, 'Rafael', '2024-10-13'),
(1, 'Amanda', '2024-10-15'), (0, 'Amanda', '2024-10-13'),
(1, 'Otto', '2024-10-15'), (0, 'Otto', '2024-10-13'),
(1, 'Rodrigo', '2024-10-15'), (0, 'Rodrigo', '2024-10-13'),
(1, 'Andre', '2024-10-15'), (0, 'Andre', '2024-10-13'),
(1, 'admin', '2024-10-15'), (0, 'admin', '2024-10-13'),
(1, 'Bigode', '2024-10-15'), (0, 'Bigode', '2024-10-13'),
(1, 'Player23', '2024-10-15'), (0, 'Player23', '2024-10-13'),
(1, 'Player13', '2024-10-15'), (0, 'Player13', '2024-10-13'),
(1, 'Player4', '2024-10-15'), (0, 'Player4', '2024-10-13');



