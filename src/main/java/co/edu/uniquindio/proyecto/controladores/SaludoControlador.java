package co.edu.uniquindio.proyecto.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo") // Prefijo común para todas las rutas del controlador
public class SaludoControlador {

    @GetMapping
    public String saludar(){
        return "Hola, bienvenido a la aplicación";
    }

    @GetMapping("/{nombre}")
    public String saludarNombre(@PathVariable String nombre){
        return "Hola %s, bienvenido a la aplicación".formatted(nombre);
    }

}
