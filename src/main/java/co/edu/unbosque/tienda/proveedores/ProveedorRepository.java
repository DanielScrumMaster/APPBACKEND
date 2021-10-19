package co.edu.unbosque.tienda.proveedores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query(value="Select * from proveedores WHERE nit_proveedor LIKE %:nit%", nativeQuery = true)
    public List<Proveedor> findProveedoresByNit(String nit);
    
}
