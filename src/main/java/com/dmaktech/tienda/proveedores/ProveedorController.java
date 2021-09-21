package com.dmaktech.tienda.proveedores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path ="/proveedores")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping(value="/listar")
    public Collection<Proveedor> getProveedores() {
        return proveedorService.obtenerProveedores();
    }
    
    @GetMapping("/listar/{id}")
    public Proveedor getProveedor(@PathVariable(name="id") Long nit) {
        return proveedorService.obtenerProveedor(nit);
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarProveedor(@RequestBody Proveedor nuevoProveedor) {
        proveedorService.agregarProveedor(nuevoProveedor);
    }

    @PutMapping("/actualizar")
    public void actualizarProveedor(@RequestBody Proveedor proveedor) {
        proveedorService.actualizarProveedor(proveedor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarProveedor(@PathVariable(name="id") Long nit){
        proveedorService.borrarProveedor(nit);
    }
}
