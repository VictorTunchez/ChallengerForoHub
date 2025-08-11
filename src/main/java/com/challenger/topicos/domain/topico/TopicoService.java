package com.challenger.topicos.domain.topico;

import com.challenger.topicos.domain.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITopicoRepository topicoRepository;

    public DetalleTopicoDto registrar(RegistroTopicoDto datos){
        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new RuntimeException("No existe un usuario con ese ID");
        }
        if(topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            throw new RuntimeException("Ya existe un topico con el mismo titulo y mensaje");
        }
        var usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        var topico = new Topico(null, usuario, datos.mensaje(), datos.nombreCurso(), datos.titulo(), LocalDateTime.now(), true);
        topicoRepository.save(topico);
        return new DetalleTopicoDto(topico);
    }

    public List<DetalleTopicoDto> listar() {
        return topicoRepository.findAllByActivoTrue().stream()
                .map(DetalleTopicoDto::new)
                .toList();
    }

    public void eliminar(Long id) {
        if(!topicoRepository.existsByIdAndActivoTrue(id)){
            throw new RuntimeException("No existe un topico activo con ese ID");
        }
        var topico = topicoRepository.getReferenceById(id);
        topico.eliminar();
    }


    public DetalleTopicoDto actualizar(Long id, ActualizacionTopicoDto datos) {
        if(!topicoRepository.existsByIdAndActivoTrue(id)){
            throw new RuntimeException("No existe un topico activo con ese ID");
        }
        var topico = topicoRepository.getReferenceById(id);
        topico.actualizar(datos);
        return new DetalleTopicoDto(topico);
    }
}
