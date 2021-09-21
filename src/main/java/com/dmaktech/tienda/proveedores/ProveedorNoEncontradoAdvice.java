package com.dmaktech.tienda.proveedores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProveedorNoEncontradoAdvice {
    
    @ExceptionHandler(ProveedorNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String proveedorNoEncontradoHandler(ProveedorNoEncontradoException ex) {
        return ex.getMessage();
    }
}
