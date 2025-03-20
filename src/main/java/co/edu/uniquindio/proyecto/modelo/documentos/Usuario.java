package co.edu.uniquindio.proyecto.modelo.documentos;

import co.edu.uniquindio.proyecto.modelo.enums.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.proyecto.modelo.enums.Rol;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document("usuarios")
public class Usuario {

    @Id
    private ObjectId id;

    private String nombre;
    private Ciudad ciudad;
    private String direccion;
    private String email;
    private String telefono;
    private String password;
    private Rol rol;
    private EstadoUsuario estado;
    private LocalDateTime fechaRegistro;

    @Builder
    public Usuario(String nombre, Ciudad ciudad, String direccion, String email, String telefono, String password, Rol rol, EstadoUsuario estado, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }
}
