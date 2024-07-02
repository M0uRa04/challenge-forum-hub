CREATE TABLE topico (

        id bigint unique not null auto_increment,
        titulo varchar (250) not null unique,
        mensagem varchar (5000) not null unique,
        data_criacao date not null,
        status_topico varchar (50) not null,

        usuario_id bigint not null,
        curso_id bigint not null,

        primary key (id),

        constraint fk_topico_usuario_id foreign key(usuario_id) references usuario(id),
        constraint fk_topico_curso_id foreign key(curso_id) references curso(id)
)