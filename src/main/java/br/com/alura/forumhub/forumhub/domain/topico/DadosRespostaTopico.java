        package br.com.alura.forumhub.forumhub.domain.topico;

        import br.com.alura.forumhub.forumhub.domain.resposta.Resposta;

        import java.time.LocalDate;
        import java.util.List;

        public record DadosRespostaTopico(
                Long id,

                String titulo,

                String mensagem,

                String curso,

                String autor,

                LocalDate data_criacao,

                StatusTopico statusTopico,

                List<Resposta> respostas

        ) {
                public DadosRespostaTopico (Topico topico) {
                        this(topico.getId(),
                                topico.getTitulo(),
                                topico.getMensagem(),
                                topico.getCurso().getNome(),
                                topico.getUsuario().getNome(),
                                topico.getData_criacao(),
                                topico.getStatus_topico(),
                                topico.getRespostas()
                        );
                }
        }
