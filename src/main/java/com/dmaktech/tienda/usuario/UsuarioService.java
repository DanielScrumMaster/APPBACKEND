package com.dmaktech.tienda.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import com.dmaktech.tienda.exceptions.UsuarioNoEncontradoException;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Collection<Usuario> getUsuarios() {
        return repository.findAll();
    }

    public Usuario getUsuario(Long cedula) {
        return repository.findById(cedula)
            .orElseThrow(() -> new UsuarioNoEncontradoException(cedula));
    }

    public void agregarUsuario(Usuario nuevoUsuario) {           
        repository.save(nuevoUsuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        repository.findById(usuario.getCedula())
            .ifPresent(user -> {
                user.setEmail(usuario.getEmail());
                user.setNombres(usuario.getNombres());
                user.setPassword(usuario.getPassword());
                user.setUsuario(usuario.getUsuario());            
            });

        repository.save(usuario);
    }

    public void borrarUsuario(Long cedula){
        Usuario user = getUsuario(cedula);
        repository.delete(user);
    }
}
