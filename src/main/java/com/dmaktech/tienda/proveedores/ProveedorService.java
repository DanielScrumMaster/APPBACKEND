package com.dmaktech.tienda.proveedores;

import java.util.Collection;

import com.dmaktech.tienda.exceptions.ProveedorNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    private ProveedorRepository repository;

    @Autowired
    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }
    
    public Collection<Proveedor> obtenerProveedores(String filtroNit){
        return repository.findProveedoresByNit(filtroNit);
    }   

    public Proveedor obtenerProveedor(Long nit){
        return repository.findById(nit)
            .orElseThrow(() -> new ProveedorNoEncontradoException(nit));
    }

    public void agregarProveedor(Proveedor nuevoProveedor) {
        repository.save(nuevoProveedor);
    }

    public void actualizarProveedor(Proveedor proveedor) {
        repository
            .findById(proveedor.getNit())
            .ifPresent(p -> repository.save(proveedor));
    }

    public void borrarProveedor(Long nit) {
        Proveedor proveedor = obtenerProveedor(nit);
        repository.delete(proveedor);
    }    
}
