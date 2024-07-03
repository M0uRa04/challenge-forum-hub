//package br.com.alura.forumhub.forumhub.controller;
//
//import br.com.alura.forumhub.forumhub.domain.usuario.DadosAutenticacao;
//import br.com.alura.forumhub.forumhub.domain.usuario.Usuario;
//import br.com.alura.forumhub.forumhub.infra.security.TokenService;
//import br.com.livraria_renascer.renascer.domain.usuario.DadosAutenticacao;
//import br.com.livraria_renascer.renascer.domain.usuario.Usuario;
//import br.com.livraria_renascer.renascer.infra.security.DadosTokenJWT;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class AutenticacaoController {
//
//    @Autowired
//    private AuthenticationManager manager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    public ResponseEntity efetuarLogin (@Valid @RequestBody DadosAutenticacao dados) {
//        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
//        var authentication = manager.authenticate(token);
//        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
//
//        return ResponseEntity.ok(new DadosAutenticacao(tokenJWT));
//    }
//}
