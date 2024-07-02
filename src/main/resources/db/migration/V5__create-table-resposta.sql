CREATE TABLE resposta (

    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    mensagem VARCHAR(300) NOT NULL UNIQUE,
    dataCriacao DATE NOT NULL,
    solucao VARCHAR (3000) NOT NULL UNIQUE,

    topico_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_resposta_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_resposta_topico_id FOREIGN KEY(topico_id) REFERENCES topico(id)
);