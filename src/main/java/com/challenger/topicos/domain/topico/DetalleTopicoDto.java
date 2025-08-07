package com.challenger.topicos.domain.topico;

import java.time.LocalDate;

public record DetalleTopicoDto(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion

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
