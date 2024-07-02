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

    @Enumerated(EnumType.STRING)
    private Perfis perfil;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <Resposta> respostas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <Topico> topicos;

    private Boolean ativo;

    public Usuario () {
        this.ativo = true;
        this.perfil = Perfis.ROLE_USER;
    }
}
