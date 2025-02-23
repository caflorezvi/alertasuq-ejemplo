package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CrearReporteDTO;
import co.edu.uniquindio.proyecto.dto.EditarReporteDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reportes")
public class ReporteControlador {

    @PostMapping
    public ResponseEntity<MensajeDTO<String>> crearReporte(@Valid @RequestBody CrearReporteDTO crearReporteDTO) throws Exception{
        //TODO Llamar al servicio de reporte para crear el reporte
        return ResponseEntity.status(201).body( new MensajeDTO<>(false, "Reporte creado exitosamente"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> editarReporte(@PathVariable String id, @Valid @RequestBody EditarReporteDTO crearReporteDTO) throws Exception{
        //TODO Llamar al servicio de reporte para editar el reporte
        return ResponseEntity.ok( new MensajeDTO<>(false, "Reporte editado exitosamente"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminaReporte(@PathVariable String id) throws Exception{
        //TODO Llamar al servicio de reporte para eliminar el reporte
        return ResponseEntity.ok( new MensajeDTO<>(false, "Reporte eliminado exitosamente"));
    }

}
