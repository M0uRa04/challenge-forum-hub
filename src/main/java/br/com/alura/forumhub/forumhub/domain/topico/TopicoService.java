package br.com.alura.forumhub.forumhub.domain.topico;

import br.com.alura.forumhub.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void cadastrar (DadosCadastroTopico dadosCadastroTopico) {

    }
}
