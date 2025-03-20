package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CrearUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.EditarUsuarioDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearUsuarioDTO cuenta) throws Exception{
        usuarioServicio.crear(cuenta);
        return ResponseEntity.status(201).body(new MensajeDTO<>(false, "Su registro ha sido exitoso"));
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO<UsuarioDTO>> obtener(@PathVariable String id) throws Exception{
        UsuarioDTO info = usuarioServicio.obtener(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, info));
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable String id) throws Exception{
        usuarioServicio.eliminar(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta eliminada exitosamente"));
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<List<UsuarioDTO>>> listarTodos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String ciudad,
            @RequestParam int pagina
    ){
        List<UsuarioDTO> lista = usuarioServicio.listarTodos(nombre, ciudad, pagina);
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping
    public ResponseEntity<MensajeDTO<String>> editarCuenta(@Valid @RequestBody EditarUsuarioDTO cuenta) throws Exception{
        usuarioServicio.editar(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta editada exitosamente"));
    }


}
