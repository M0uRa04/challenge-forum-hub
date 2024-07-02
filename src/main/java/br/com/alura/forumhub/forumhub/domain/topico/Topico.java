package br.com.alura.forumhub.forumhub.domain.topico;

import br.com.alura.forumhub.forumhub.domain.curso.Curso;
import br.com.alura.forumhub.forumhub.domain.resposta.Resposta;
import br.com.alura.forumhub.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_criacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status_topico;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    public Topico () { 
        this.status_topico = StatusTopico.NAO_RESPONDIDO;
        this.data_criacao = LocalDate.now();
    }

    public Topico(DadosCadastroTopico dadosCadastroTopico, Optional<Usuario> autor, Optional<Curso> curso) {
        this.status_topico = StatusTopico.NAO_RESPONDIDO;
        this.data_criacao = LocalDate.now();
        this.titulo = dadosCadastroTopico.titulo();
        this.mensagem = dadosCadastroTopico.mensagem();

        if (autor.isEmpty() || curso.isEmpty()) {
            throw new IllegalArgumentException("Id informado do curso ou autor inexistente");
        }

        this.usuario = autor.get();
        this.curso = curso.get();
    }
}
