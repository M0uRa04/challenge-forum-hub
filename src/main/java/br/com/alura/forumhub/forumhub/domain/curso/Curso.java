package br.com.alura.forumhub.forumhub.domain.curso;


import br.com.alura.forumhub.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean ativo;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private List<Topico> topico;

    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoriaCurso;

    public Curso () {
        this.ativo = true;
    }
}
