package co.edu.unbosque.tienda.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import co.edu.unbosque.tienda.exceptions.UsuarioNoEncontradoException;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Collection<Usuario> getUsuarios(String filtroCedula) {        
        return repository.findByCedulaContaining(filtroCedula);
    }

    public Usuario getUsuario(Long cedula) {
        return repository.findById(cedula)
            .orElseThrow(() -> new UsuarioNoEncontradoException(cedula));
    }

    public void agregarUsuario(Usuario nuevoUsuario) {           
        repository.save(nuevoUsuario);
    }

    public void actualizarUsuario(Usuario usuario, Long cedula) {
        repository
            .findById(cedula)
            .ifPresentOrElse(
                (usuarioAntiguo) -> {
                    usuario.setCedula(cedula);
                    repository.save(usuario);
                }, 
                () -> {
                    throw new UsuarioNoEncontradoException(cedula);
                });
    }

    public void borrarUsuario(Long cedula){
        Usuario user = getUsuario(cedula);
        repository.delete(user);
    }
}
