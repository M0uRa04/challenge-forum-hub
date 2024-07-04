package br.com.alura.forumhub.forumhub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    UserDetails findByLogin(String login);

    @Query("Select u from Usuario u where login = :login")
    Usuario findByEmail (String login);
}
