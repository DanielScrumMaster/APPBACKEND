package co.edu.unbosque.tienda.productos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Collection<Producto> getProductos(@RequestParam Optional<String> filtroCodigo) {
        return productoService.getProductos(filtroCodigo.orElse(""));
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long codigo) {
        Producto producto = productoService.getProducto(codigo);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public void guardarProducto(@RequestParam("productos") MultipartFile productosCSV) {
        if(!productosCSV.getContentType().equals("text/csv"))
                throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Sólo se aceptan archivos de tipo CSV");

        productoService.guardarProductos(productosCSV);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Object> actualizarProducto(@PathVariable Long codigo, @RequestBody Producto producto) {
        productoService.actualizarProducto(codigo, producto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigo}")
    public void borrarProducto(@PathVariable Long codigo) {
        productoService.borrarProducto(codigo);
    }
}
