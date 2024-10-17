# VER DATABASES DEFAULTS
SHOW DATABASES;

# CRIAR DATABASE NOVO E VER ELE JUNTO COM OS DEFAULTS
                # DATABASE
CREATE DATABASE PROFESSORES;
SHOW DATABASES;

# ACESSAR O DATABASE E CRIAR UMA TABLE
    # DATABASE
USE PROFESSORES;
            # TABLE NAME
CREATE TABLE PROFESSOR(
    # VALUES
    nome VARCHAR(60) NOT NULL,
    idade INT,
    matricula INT
);

# VER TABELA CRIADA
SHOW TABLES;
        # TABLE
DESCRIBE PROFESSOR;

# VER TODOS OS DADOS DA TABELA
            # TABLE
SELECT * FROM PROFESSOR;

# DELETAR TABLE E DATABASE
            # TABLE
#DROP TABLE PROFESSOR;
            # DATABASE
#DROP DATABASE PROFESSORES;
