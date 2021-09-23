package com.dmaktech.tienda.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    Collection<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{cedula}")
    Usuario getUsuario(@PathVariable Long cedula) {
        return usuarioService.getUsuario(cedula);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void agregarUsuario(@RequestBody Usuario nuevoUsuario){
        usuarioService.agregarUsuario(nuevoUsuario);
    }

    @PutMapping("/{cedula}")
    void actualizarUsuario(@RequestBody Usuario datosUsuario) {
        usuarioService.actualizarUsuario(datosUsuario);
    }

    @DeleteMapping("/{cedula}")
    void borrarUsuario(@PathVariable Long cedula){
        usuarioService.borrarUsuario(cedula);
    }
}
