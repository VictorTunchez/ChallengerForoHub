package com.challenger.topicos.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutenticacionUsuarioDto(
         @Email @NotBlank String email,
         @NotBlank String contrasena
) {
}
