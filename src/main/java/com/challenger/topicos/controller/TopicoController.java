package com.challenger.topicos.controller;

import com.challenger.topicos.domain.topico.RegitroTopicoDto;
import com.challenger.topicos.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody RegitroTopicoDto datos){
        var topicoDetalle = service.registrar(datos);
        return ResponseEntity.ok(topicoDetalle);
    }
}
