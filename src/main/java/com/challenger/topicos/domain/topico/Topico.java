package com.challenger.topicos.domain.topico;

import com.challenger.topicos.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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
    private LocalDateTime fechaCreacion;
    private Boolean activo;

    public void eliminar(){
        this.activo = false;
    }


    public void actualizar(ActualizacionTopicoDto datos) {
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.nombreCurso() != null){
            this.nombreCurso = datos.nombreCurso();
        }
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }

    }
}
