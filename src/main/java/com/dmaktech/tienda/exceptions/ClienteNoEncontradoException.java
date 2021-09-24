package com.dmaktech.tienda.exceptions;

public class ClienteNoEncontradoException extends RuntimeException{
    
    private Long cedula;

    public ClienteNoEncontradoException(Long cedula) {
        super("No se encontró al cliente con la cédula " + cedula);
        this.cedula = cedula;
    }

    public Long getCedula() {
        return cedula;
    }
}
