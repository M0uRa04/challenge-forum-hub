CREATE TABLE resposta (

    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    mensagem VARCHAR(300) NOT NULL UNIQUE,
    data_criacao DATE NOT NULL,
    solucao varchar(2000) NOT NULL,
     UNIQUE (mensagem(100)),

    topico_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    ativo boolean not null,

    PRIMARY KEY (id),

    CONSTRAINT fk_resposta_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_resposta_topico_id FOREIGN KEY(topico_id) REFERENCES topico(id)
);