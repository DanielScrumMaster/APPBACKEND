package co.edu.unbosque.tienda.productos;

import java.util.Collection;

import co.edu.unbosque.tienda.exceptions.ProductoNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;

    public Collection<Producto> getProductos(String filtroCodigo){
        return repository.findByCodigoContaining(filtroCodigo);
    }

    public Producto getProducto(Long codigo) {
        return repository.findById(codigo)
            .orElseThrow(() -> new ProductoNoEncontradoException(codigo));
    }

    public void guardarProductos(MultipartFile productosCSV) {
        Collection<Producto> productos = ProductoMapper.csvToProducts(productosCSV);        
        repository.saveAll(productos);
    }

    public void actualizarProducto(Long codigo, Producto producto) {
        repository
        .findById(codigo)
        .ifPresentOrElse(
            (usuarioAntiguo) -> {
                producto.setCodigo(codigo);
                repository.save(producto);
            }, 
            () -> {
                throw new ProductoNoEncontradoException(codigo);
            });
    }

    public void borrarProducto(Long codigo) {
        Producto producto = getProducto(codigo);
        repository.delete(producto);
    }
}
