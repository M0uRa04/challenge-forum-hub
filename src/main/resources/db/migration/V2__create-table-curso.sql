CREATE TABLE curso (

    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    categoria VARCHAR (60) NOT NULL,

    ativo boolean not null,
    PRIMARY KEY (id)
);