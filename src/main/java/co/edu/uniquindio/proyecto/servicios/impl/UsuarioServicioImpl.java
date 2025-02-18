package co.edu.uniquindio.proyecto.servicios.impl;

import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final ArrayList<Usuario> usuarios;

    public UsuarioServicioImpl() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void crear(CrearUsuarioDTO cuenta) throws Exception {
        this.usuarios.add(
                Usuario
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .nombre(cuenta.nombre())
                        .ciudad(cuenta.ciudad())
                        .direccion(cuenta.direccion())
                        .telefono(cuenta.telefono())
                        .email(cuenta.email())
                        .password(cuenta.password())
                        .fechaCreacion(LocalDateTime.now())
                        .build()
        );
    }

    @Override
    public void eliminar(String id) throws Exception {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        usuarios.remove(usuario);
    }

    @Override
    public void editar(EditarUsuarioDTO cuenta) throws Exception {
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(cuenta.id()))
                .findFirst()
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        usuario.setNombre(cuenta.nombre());
        usuario.setCiudad(cuenta.ciudad());
        usuario.setDireccion(cuenta.direccion());
        usuario.setTelefono(cuenta.telefono());
    }

    @Override
    public UsuarioDTO obtener(String id) throws Exception {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getCiudad(),
                        usuario.getDireccion(),
                        usuario.getEmail()
                ))
                .findFirst()
                .orElseThrow(() -> new Exception("Usuario no encontrado"));
    }

    @Override
    public List<UsuarioDTO> listarTodos(String nombre, String ciudad) {

        List<Usuario> usuariosLista;

        if (nombre != null && ciudad != null) {
            usuariosLista = usuarios.stream()
                    .filter(usuario -> usuario.getNombre().contains(nombre) && usuario.getCiudad().contains(ciudad))
                    .toList();
        } else if (nombre != null) {
            usuariosLista = usuarios.stream()
                    .filter(usuario -> usuario.getNombre().contains(nombre))
                    .toList();
        } else if (ciudad != null) {
            usuariosLista = usuarios.stream()
                    .filter(usuario -> usuario.getCiudad().contains(ciudad))
                    .toList();
        } else {
            usuariosLista = usuarios;
        }

        return usuariosLista.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getCiudad(),
                        usuario.getDireccion(),
                        usuario.getEmail()
                ))
                .toList();

    }
}
