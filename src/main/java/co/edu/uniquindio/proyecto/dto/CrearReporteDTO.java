package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CrearReporteDTO(
        @NotBlank @Length(max = 150) String titulo,
        @NotBlank @Length(max = 400) String descripcion,
        @NotEmpty List<String> rutaImagenes,
        @NotBlank String categoria,
        @NotNull Ubicacion ubicacion,
        @NotBlank String idUsuario
) {
}
