package br.com.alura.forumhub.forumhub.controller;

import br.com.alura.forumhub.forumhub.domain.topico.DadosAtualizacaoTopico;
import br.com.alura.forumhub.forumhub.domain.topico.DadosCadastroTopico;
import br.com.alura.forumhub.forumhub.domain.topico.DadosRespostaTopico;
import br.com.alura.forumhub.forumhub.domain.topico.TopicoService;
import br.com.alura.forumhub.forumhub.domain.usuario.UsuarioRepository;
import br.com.alura.forumhub.forumhub.infra.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity listaTopicos () {
        try {
            var listaDeTopicos = topicoService.listarTopicosAtivos();
            return ResponseEntity.ok(listaDeTopicos);
        } catch (RuntimeException ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping ("/{id}")
    public ResponseEntity buscaTopicoPorId (@PathVariable Long id) {
        var topico = topicoService.buscaTopicoPorId(id);
        return ResponseEntity.ok().body(new DadosRespostaTopico(topico));
    }

    @PostMapping
    public ResponseEntity cadastraTopicos (@Valid @RequestBody DadosCadastroTopico dados, HttpServletRequest request) {
        var login = tokenService.getSubject(tokenService.getTokenJWT(request));
        var idDoUsuario = usuarioRepository.findByEmail(login).getId();
        var topicoCadastrado = topicoService.cadastrar(dados, idDoUsuario);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        var topicoDeResposta = new DadosRespostaTopico(topicoCadastrado);
        return ResponseEntity.created(uri).body(topicoDeResposta);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaTopico (@Valid @RequestBody DadosAtualizacaoTopico dados, HttpServletRequest request) {
        var login = tokenService.getSubject(tokenService.getTokenJWT(request));
        var topicoAntigo = topicoService.buscaTopicoPorId(dados.id());
        if (login.equals(topicoAntigo.getUsuario().getLogin())) {
            var topicoAtualizado = topicoService.atualiza(dados);
            return ResponseEntity.ok(new DadosRespostaTopico(topicoAtualizado));
        }
       return ResponseEntity.badRequest().body("Somente o autor do tópico pode atualiza-lo.");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico (@Valid @PathVariable Long id, HttpServletRequest request) {
        var login = tokenService.getSubject(tokenService.getTokenJWT(request));
        var topicoParaSerDeletado = topicoService.buscaTopicoPorId(id);
        if (login.equals(topicoParaSerDeletado.getUsuario().getLogin())) {
            topicoService.deleta(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Somente o autor do tópico pode deleta-lo.");
    }
}
