package com.dmaktech.tienda.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path ="/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    Collection<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/listar/{id}")
    Usuario getUsuario(Long cedula) {
        return usuarioService.getUsuario(cedula);
    }

    @PostMapping("/guardar")
    void agregarUsuario(Usuario nuevoUsuario){
        usuarioService.agregarUsuario(nuevoUsuario);
    }

    @PutMapping("/actualizar")
    void actualizarUsuario(Usuario datosUsuario) {
        usuarioService.actualizarUsuario(datosUsuario);
    }

    @DeleteMapping("/eliminar/{id}")
    void borrarUsuario(Long cedula){
        usuarioService.borrarUsuario(cedula);
    }
}
