package br.com.alura.forumhub.forumhub.domain.usuario;

import br.com.alura.forumhub.forumhub.domain.resposta.Resposta;
import br.com.alura.forumhub.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @ElementCollection(targetClass = Perfis.class)
    @Enumerated(EnumType.STRING)
    private List<Perfis> perfis;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <Resposta> respostas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <Topico> topicos;

    private Boolean ativo;

    public Usuario () {
        this.ativo = true;
        this.perfis = new ArrayList<>();
        this.perfis.add(Perfis.ROLE_USER);
    }
}
