package com.challenger.topicos.controller;

import com.challenger.topicos.domain.usuario.AutenticacionUsuarioDto;
import com.challenger.topicos.domain.usuario.Usuario;
import com.challenger.topicos.infra.TokenJwtDto;
import com.challenger.topicos.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionUsuarioController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid AutenticacionUsuarioDto datos){
        var autenticationToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasena());
        var autenticacion =manager.authenticate(autenticationToken);
        var tokenJwt = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(tokenJwt));
    }
}
