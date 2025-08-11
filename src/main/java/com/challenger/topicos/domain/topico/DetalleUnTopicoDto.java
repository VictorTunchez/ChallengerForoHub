package com.challenger.topicos.domain.topico;

import java.time.LocalDateTime;

public record DetalleUnTopicoDto(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Long idUsuario,
        String curso
) {
    public DetalleUnTopicoDto(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getUsuario().getId(),
                topico.getNombreCurso()
                );
    }
}
