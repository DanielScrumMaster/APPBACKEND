package com.dmaktech.tienda.usuario;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UsuarioService {
    private static final List<Usuario> defaultUsers = List.of(
            new Usuario(123L, "Daniel", "dan@gmail.com", "123", "dan123"),
            new Usuario(123L, "Daniel", "dan@gmail.com", "123", "dan123")
            );

    public Collection<Usuario> getUsuarios() {
        return defaultUsers;
    }

    public Usuario getUsuario(Long cedula) {
        return defaultUsers.stream().filter(user -> cedula.equals(user.getCedula())).findFirst().get();
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        defaultUsers.add(nuevoUsuario);
    }

    public void actualizarUsuario(Usuario nuevosDatosUsuario) {
        Usuario u = getUsuario(nuevosDatosUsuario.getCedula());
        u.setEmail(nuevosDatosUsuario.getEmail());
        u.setNombres(nuevosDatosUsuario.getNombres());
        u.setUsuario(nuevosDatosUsuario.getUsuario());
        u.setPassword(nuevosDatosUsuario.getPassword());
    }

    public void borrarUsuario(Long cedula){
        defaultUsers.removeIf(user -> cedula.equals(user.getCedula()));
    }
}
