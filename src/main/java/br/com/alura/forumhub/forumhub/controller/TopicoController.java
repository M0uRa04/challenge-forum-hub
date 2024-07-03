package br.com.alura.forumhub.forumhub.controller;

import br.com.alura.forumhub.forumhub.domain.topico.DadosAtualizacaoTopico;
import br.com.alura.forumhub.forumhub.domain.topico.DadosCadastroTopico;
import br.com.alura.forumhub.forumhub.domain.topico.DadosRespostaTopico;
import br.com.alura.forumhub.forumhub.domain.topico.TopicoService;
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
    private TopicoService service;

    @GetMapping
    public ResponseEntity listaTopicos () {
        try {
            var listaDeTopicos = service.listarTopicosAtivos();
            return ResponseEntity.ok(listaDeTopicos);
        } catch (RuntimeException ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping ("/{id}")
    public ResponseEntity buscaTopicoPorId (@PathVariable Long id) {
        var topico = service.buscaTopicoPorId(id);
        return ResponseEntity.ok().body(new DadosRespostaTopico(topico));
    }

    @PostMapping
    public ResponseEntity cadastraTopicos (@Valid @RequestBody DadosCadastroTopico dados) {
        var topicoCadastrado = service.cadastrar(dados);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        var topicoDeResposta = new DadosRespostaTopico(topicoCadastrado);
        return ResponseEntity.created(uri).body(topicoDeResposta);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaTopico (@Valid @RequestBody DadosAtualizacaoTopico dados) {
        var topico = service.atualiza(dados);
        return ResponseEntity.ok(new DadosRespostaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico (@Valid @PathVariable Long id) {
        service.deleta(id);
        return ResponseEntity.noContent().build();
    }
}
