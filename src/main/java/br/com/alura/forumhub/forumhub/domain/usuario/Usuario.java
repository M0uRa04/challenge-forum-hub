package br.com.alura.forumhub.forumhub.domain.usuario;

import br.com.alura.forumhub.forumhub.domain.resposta.Resposta;
import br.com.alura.forumhub.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
