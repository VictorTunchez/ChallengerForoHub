package com.challenger.topicos.domain.topico;


public record RegitroTopicoDto(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
