package com.challenger.topicos.domain.topico;

import com.challenger.topicos.domain.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TopicoService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITopicoRepository topicoRepository;

    public DetalleTopicoDto registrar(RegitroTopicoDto datos){
        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new RuntimeException("No existe un usuario con ese ID");
        }
        var usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        var topico = new Topico(null, usuario, datos.mensaje(), datos.nombreCurso(), datos.titulo(), LocalDate.now());
        topicoRepository.save(topico);
        return new DetalleTopicoDto(topico);
    }
}
