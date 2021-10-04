package com.dmaktech.tienda.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value="Select * from usuarios u where u.ced_usuario like %:cedula%", nativeQuery=true)
    List<Usuario> findByCedulaContaining(String cedula); 
}
