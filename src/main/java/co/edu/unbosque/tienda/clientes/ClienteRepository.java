package co.edu.unbosque.tienda.clientes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value="Select * from clientes WHERE ced_cliente LIKE %:cedula%", nativeQuery = true)
    public List<Cliente> findClientesByCedula(String cedula);
}
