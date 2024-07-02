CREATE TABLE usuario (

    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL UNIQUE,
    email VARCHAR(60) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    ativo boolean not null,
    perfil VARCHAR (50) NOT NULL,

    PRIMARY KEY (id)
);