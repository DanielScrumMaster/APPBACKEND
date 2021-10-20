package co.edu.unbosque.tienda.ventas;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/ventas")
public class VentaController {
        
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public Collection<Venta> getVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/{id}")
    public Venta getVenta(@PathVariable Long id) {
        return ventaService.getVenta(id);
    }

    @PostMapping
    public ResponseEntity<Object> agregarVenta(@RequestBody Venta nuevaVenta) {
        
        Venta ventaCreada =  ventaService.crearVenta(nuevaVenta);

        return ResponseEntity
          .created(URI.create(String.format("/ventas/%d", ventaCreada.getId())))
          .body(ventaCreada);
    }

    @PutMapping(value="/{idVenta}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long idVenta, @RequestBody Venta venta) {
        
        Venta ventaActualizada = ventaService.actualizarVenta(idVenta, venta);
        
        return ResponseEntity.ok().body(ventaActualizada);
    }

    @DeleteMapping("/{idVenta}")
    public void borrarVenta(@PathVariable Long idVenta) {
        ventaService.borrarVenta(idVenta);
    }
}
