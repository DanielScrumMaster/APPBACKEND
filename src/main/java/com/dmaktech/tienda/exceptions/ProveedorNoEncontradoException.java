package com.dmaktech.tienda.exceptions;

public class ProveedorNoEncontradoException extends RuntimeException{

    private Long nit;

    public ProveedorNoEncontradoException(Long nit) {
        super("No se encontró al proveedor con nit " + nit);
        this.nit = nit;
    }

    public Long getNit() {
        return nit;
    }
}
