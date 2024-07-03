package br.com.alura.forumhub.forumhub.domain.topico;

import br.com.alura.forumhub.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public Topico cadastrar (DadosCadastroTopico dadosCadastroTopico) {
        var autor = usuarioRepository.findById(dadosCadastroTopico.idUsuario());
        var curso = cursoRepository.findById(dadosCadastroTopico.idCurso());

        var novoTopico = new Topico(dadosCadastroTopico, autor, curso);
        topicoRepository.save(novoTopico);
        return novoTopico;
    }

    public List<DadosRespostaTopico> listarTopicosAtivos() {
         var listaDeTopicos = topicoRepository.findAll().stream()
                .map(DadosRespostaTopico::new)
                .collect(Collectors.toList());
        return listaDeTopicos;
    }

    public Topico buscaTopicoPorId(Long id) {
        return topicoRepository.findById(id).orElseThrow();
    }

    public Topico atualiza(DadosAtualizacaoTopico dados) {
        var topicoRecuperado = topicoRepository.findById(dados.id()).orElseThrow(() -> new RuntimeException("Topico não encontrado para o Id Fornecido"));

        if (!dados.titulo().isBlank()) {
            topicoRecuperado.setTitulo(dados.titulo());
        }
        if (!dados.mensagem().isBlank()) {
            topicoRecuperado.setMensagem(dados.mensagem());
        }
        return topicoRepository.save(topicoRecuperado);
    }

    public void deleta (Long id) {
        topicoRepository.deleteById(id);
    }
}
