package co.edu.uniquindio.proyecto.excepciones;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ValidacionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<MensajeDTO<String>> noResourceFoundExceptionHandler(NoResourceFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new MensajeDTO<>(true, "El recurso no fue encontrado") );
    }

    @ExceptionHandler(ElementoNoEncontradoException.class)
    public ResponseEntity<MensajeDTO<String>> elementoNoEncontradoExceptionHandler(ElementoNoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new MensajeDTO<>(true, ex.getMessage()) );
    }

    @ExceptionHandler(ElementoRepetidoException.class)
    public ResponseEntity<MensajeDTO<String>> elementoRepetidoExceptionHandler(ElementoRepetidoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body( new MensajeDTO<>(true, ex.getMessage()) );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDTO<String>> generalExceptionHandler(Exception e){
        return ResponseEntity.internalServerError().body( new MensajeDTO<>(true, e.getMessage()) );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDTO<List<ValidacionDTO>>> validationExceptionHandler( MethodArgumentNotValidException ex ) {

        List<ValidacionDTO> errores = ex.getFieldErrors()
                .stream()
                .map(x -> new ValidacionDTO(x.getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body( new MensajeDTO<>(true, errores) );
    }

}

