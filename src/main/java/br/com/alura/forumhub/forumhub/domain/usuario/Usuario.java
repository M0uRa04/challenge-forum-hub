package br.com.alura.forumhub.forumhub.domain.usuario;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated
    private List<Perfis> perfis;

    private Boolean ativo;

    public Usuario () {
        this.ativo = true;
        this.perfis.add(Perfis.ROLE_USER);
    }
}
