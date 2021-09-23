package com.dmaktech.tienda.clientes;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
    
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    Collection<Cliente> getClientes() {
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{cedula}")
    Cliente getCliente(@PathVariable Long cedula)  {
        return clienteService.obtenerCliente(cedula);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarCliente(@RequestBody Cliente nuevoCliente) {
        clienteService.agregarCliente(nuevoCliente);
    }        

    @PutMapping("/{cedula}")
    public void actualizarCliente(@RequestBody Cliente cliente) {
        clienteService.actualizarCliente(cliente);
    }

    @DeleteMapping("/{cedula}")
    public void borrarCliente(@PathVariable Long cedula) {
        clienteService.borrarCliente(cedula);
    }
}
