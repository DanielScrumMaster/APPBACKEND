package co.edu.unbosque.tienda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //--------------USUARIOS EXCEPTIONS-------------------------

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Object> usuarioNoEncontradoHandler(UsuarioNoEncontradoException ex) {
        return ResponseEntity.notFound().build();        
    }  

    //--------------CLIENTES EXCEPTIONS-------------------------
    
    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<String> clienteNoEncontradoHandler(ClienteNoEncontradoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }    
    
    //--------------PROVEEDORES EXCEPTIONS-------------------------

    @ExceptionHandler(ProveedorNoEncontradoException.class)
    public ResponseEntity<String> proveedorNoEncontradoHandler(ProveedorNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //--------------PRODUCTOS EXCEPTIONS-------------------------
    
    @ExceptionHandler(CSVFileException.class)
    public ResponseEntity<?> handleCSVFormatException(CSVFileException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ProductoNoEncontradoException.class)       
    public ResponseEntity<String> handleProductoNoEncontrado(ProductoNoEncontradoException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    //--------------VENTAS EXCEPTIONS-------------------------
    
    @ExceptionHandler(VentaNotFoundException.class)
    public ResponseEntity<Object> handleVentaNotFound(VentaNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }    

    //--------------DETALLES VENTAS EXCEPTIONS-------------------------
    @ExceptionHandler(DetalleVentaNotFoundException.class)
    public ResponseEntity<Object> handleDetalleVentaNotFound(DetalleVentaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
