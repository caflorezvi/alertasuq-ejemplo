package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enums.Ciudad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EditarUsuarioDTO(
    @NotBlank String id,
    @NotBlank @Length(max = 100) String nombre,
    @NotNull Ciudad ciudad,
    @NotBlank @Length(max = 100) String direccion,
    @Length(max = 10) String telefono
) {
}
