package br.com.alura.forumhub.forumhub.controller;

import br.com.alura.forumhub.forumhub.domain.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private picoService service;
}
