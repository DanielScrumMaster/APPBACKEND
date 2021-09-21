package com.dmaktech.tienda.usuario;

public class UsuarioNoEncontradoException extends RuntimeException{
    private Long cedula;

    public UsuarioNoEncontradoException(Long cedula) {
        super("No se encontró al usuario con la cédula " + cedula);
        this.cedula = cedula;
    }

    public Long getCedula() {
        return cedula;
    }    
}
