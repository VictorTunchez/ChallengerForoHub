package com.challenger.topicos.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findAllByActivoTrue();
}
