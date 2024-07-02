CREATE TABLE usuario (

    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL UNIQUE,
    email VARCHAR(60) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,

    perfil_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_usuario_perfil_id FOREIGN KEY(perfil_id) REFERENCES perfil(id)
);