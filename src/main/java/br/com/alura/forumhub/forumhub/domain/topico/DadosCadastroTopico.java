        package br.com.alura.forumhub.forumhub.domain.topico;

        import jakarta.validation.constraints.NotBlank;
        import jakarta.validation.constraints.NotNull;

        public record DadosCadastroTopico(

                @NotBlank
                String titulo,

                @NotBlank
                String mensagem,

                @NotNull
                Long idCurso,

                @NotNull
                Long idUsuario
        ) {}
