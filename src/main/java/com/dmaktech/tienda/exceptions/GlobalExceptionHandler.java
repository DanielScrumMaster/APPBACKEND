package com.dmaktech.tienda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //--------------USUARIOS EXCEPTIONS-------------------------

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> usuarioNoEncontradoHandler(UsuarioNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(CSVFormatException.class)
    public ResponseEntity<?> handleCSVFormatException(CSVFormatException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)       
    public ResponseEntity<String> handleProductoNoEncontrado(ProductoNoEncontradoException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
