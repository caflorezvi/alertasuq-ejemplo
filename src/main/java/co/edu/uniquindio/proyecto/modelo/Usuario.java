package co.edu.uniquindio.proyecto.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Usuario {
    private String id;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private LocalDateTime fechaCreacion;
}
