package com.challenger.topicos.domain.topico;

import com.challenger.topicos.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String mensaje;
    private String nombreCurso;
    private String titulo;
    private LocalDate fechaCreacion;


//    public Topico(RegitroTopicoDto datos){
//        this.id = null;
//        this.usuario = datos.idUsuario();
//        this.mensaje = datos.mensaje();
//        this.nombreCurso = datos.nombreCurso();
//        this.titulo = datos.titulo();
//        this.fechaCreacion = LocalDate.now();
//    }
}
