package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.Ciudad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CrearUsuarioDTO(
        @NotBlank @Length(max = 100) String nombre,
        @Length(max = 10) String telefono,
        @NotNull Ciudad ciudad,
        @NotBlank @Length(max = 100) String direccion,
        @NotBlank @Length(max = 50) @Email String email,
        @NotBlank @Length(min = 7, max = 20) String password
) {
}

