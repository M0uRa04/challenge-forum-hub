package br.com.alura.forumhub.forumhub.controller;

import br.com.alura.forumhub.forumhub.domain.topico.DadosCadastroTopico;
import br.com.alura.forumhub.forumhub.domain.topico.DadosRespostaTopico;
import br.com.alura.forumhub.forumhub.domain.topico.TopicoService;
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

    @PostMapping
    public ResponseEntity cadastraTopicos (@Valid @RequestBody DadosCadastroTopico dados) {
        var topicoCadastrado = service.cadastrar(dados);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        var topicoDeResposta = new DadosRespostaTopico(topicoCadastrado);
        return ResponseEntity.created(uri).body(topicoDeResposta);
    }
}
