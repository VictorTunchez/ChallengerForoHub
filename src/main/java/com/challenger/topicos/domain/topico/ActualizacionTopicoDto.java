package com.challenger.topicos.domain.topico;

public record ActualizacionTopicoDto(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {

}
