package br.com.alura.forumhub.forumhub.controller;

import br.com.alura.forumhub.forumhub.domain.topico.DadosCadastroTopico;
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
        return ResponseEntity.ok("Listando tópicos");
    }

    @PostMapping
    public ResponseEntity cadastraTopicos (@Valid @RequestBody DadosCadastroTopico dados) {
        var topicoCadastrado = service.cadastrar(dados);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        return ResponseEntity.created(uri).body(topicoCadastrado);
    }
}
