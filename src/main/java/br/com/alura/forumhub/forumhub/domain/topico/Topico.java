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

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico;

    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas;

    public Topico () {
        this.statusTopico = StatusTopico.NAO_RESPONDIDO;
    }
}
