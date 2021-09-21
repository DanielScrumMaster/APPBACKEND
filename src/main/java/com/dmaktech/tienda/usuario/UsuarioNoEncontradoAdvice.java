package com.dmaktech.tienda.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNoEncontradoAdvice {
    @ResponseBody
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String usuarioNoEncontradoHandler(UsuarioNoEncontradoException ex) {
        return ex.getMessage();
    }    
}
