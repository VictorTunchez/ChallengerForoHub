package com.challenger.topicos.domain.topico;

import java.time.LocalDateTime;

public record DetalleTopicoDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion

) {
    public DetalleTopicoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion()
        );
    }
}
