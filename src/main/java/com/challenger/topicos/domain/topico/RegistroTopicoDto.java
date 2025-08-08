package com.challenger.topicos.domain.topico;


public record RegistroTopicoDto(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
