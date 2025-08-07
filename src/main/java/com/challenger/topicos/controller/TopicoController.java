package com.challenger.topicos.controller;

import com.challenger.topicos.domain.topico.DetalleTopicoDto;
import com.challenger.topicos.domain.topico.ITopicoRepository;
import com.challenger.topicos.domain.topico.RegitroTopicoDto;
import com.challenger.topicos.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private ITopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody RegitroTopicoDto datos){
        var topicoDetalle = service.registrar(datos);
        return ResponseEntity.ok(topicoDetalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleTopicoDto>>  listar(){
        var detalles = repository.findAll().stream()
                .map(DetalleTopicoDto::new)
                .toList();
        return ResponseEntity.ok(detalles);
    }
}
