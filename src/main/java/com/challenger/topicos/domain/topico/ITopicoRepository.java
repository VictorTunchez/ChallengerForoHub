package com.challenger.topicos.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findAllByActivoTrue();

    boolean existsByIdAndActivoTrue(Long id);

    boolean existsByTituloAndMensaje( String titulo, String mensaje);
}
