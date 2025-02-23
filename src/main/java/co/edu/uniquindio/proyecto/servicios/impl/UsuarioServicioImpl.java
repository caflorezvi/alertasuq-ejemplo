package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Override
    public void crear(CrearUsuarioDTO cuenta) throws Exception {
        //TODO Aqui se debe implementar la logica de creacion de un usuario
    }

    @Override
    public void eliminar(String id) throws Exception {
        //TODO Aqui se debe implementar la logica de eliminacion de un usuario
    }

    @Override
    public void editar(EditarUsuarioDTO cuenta) throws Exception {
        //TODO Aqui se debe implementar la logica de edicion de un usuario
    }

    @Override
    public UsuarioDTO obtener(String id) throws Exception {
        //TODO Aqui se debe implementar la logica de obtencion de un usuario
        return new UsuarioDTO(
            UUID.randomUUID().toString(),
            "Carlos",
            "Armenia",
            "Calle 123",
            "carlos@email.com"
        );
    }

    @Override
    public List<UsuarioDTO> listarTodos(String nombre, String ciudad) {
        //TODO Aqui se debe implementar la logica de listado de usuarios y filtrado por nombre y ciudad
        return List.of(
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Carlos",
                "Armenia",
                "Calle 123",
                "carlos@email.com"),
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Maria",
                "Calarcá",
                "Calle 456",
                "maria@email.com"),
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Pedro",
                "Bogotá",
                "Calle 789",
                "pedro@email.com")
        );

    }
}
