package br.com.alura.forumhub.forumhub.domain.resposta;


import br.com.alura.forumhub.forumhub.domain.topico.Topico;
import br.com.alura.forumhub.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topico topico;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataCriacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    private String solucao;

    private Boolean ativo;

    public Resposta () {
        this.ativo = true;
    }
}
