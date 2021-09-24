package com.dmaktech.tienda.clientes;

import java.util.Collection;

import com.dmaktech.tienda.exceptions.ClienteNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    
    public Collection<Cliente> obtenerClientes() {
        return repository.findAll();
    }  

    public Cliente obtenerCliente(Long cedula) {
        return repository.findById(cedula)
            .orElseThrow(() -> new ClienteNoEncontradoException(cedula));
    }
    
    public void agregarCliente(Cliente nuevoCliente){
        repository.save(nuevoCliente);
    }

    public void actualizarCliente(Cliente cliente) {
        repository.findById(cliente.getCedula())
            .ifPresent(client -> {
                repository.save(cliente);
            });        
    }

    public void borrarCliente(Long cedula) {
        Cliente cliente = obtenerCliente(cedula);
        repository.delete(cliente);
    }
}
