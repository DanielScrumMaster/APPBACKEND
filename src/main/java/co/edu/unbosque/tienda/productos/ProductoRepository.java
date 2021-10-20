package co.edu.unbosque.tienda.productos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
 
    @Query(value="Select * from productos p where p.cod_producto like %:codigo%", nativeQuery=true)
    List<Producto> findByCodigoContaining(String codigo); 
    
}
