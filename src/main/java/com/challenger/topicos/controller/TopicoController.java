package com.challenger.topicos.controller;

import com.challenger.topicos.domain.topico.*;
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
    public ResponseEntity registrar(@RequestBody RegistroTopicoDto datos){
        var topicoDetalle = service.registrar(datos);
        return ResponseEntity.ok(topicoDetalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleTopicoDto>>  listar(){
        var detalles = service.listar();
        return ResponseEntity.ok(detalles);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody ActualizacionTopicoDto datos){
        var detalles = service.actualizar(id,datos);
        return ResponseEntity.ok(detalles);
    }

}
