package co.edu.unbosque.tienda.detalles_venta;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/detalleventas")
public class DetalleVentaController {
    
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public Collection<DetalleVenta> getDetallesVentas() {
        return detalleVentaService.getDetallesVentas();
    }

    @GetMapping("/{codigo}")
    public DetalleVenta getDetalleVenta(@PathVariable Long codigo) {
        return detalleVentaService.getDetalleVenta(codigo);
    }

    @PostMapping
    public ResponseEntity<Object> crearDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        detalleVentaService.crearDetalleVenta(detalleVenta);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Object> actualizarDetalleVenta(@PathVariable Long codigo, @RequestBody DetalleVenta detalleVenta) {
        detalleVentaService.actualizarDetalleVenta(codigo, detalleVenta);
        return ResponseEntity.ok().build();
    }

    

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> borrarDetalleVenta(@PathVariable Long codigo) {
        detalleVentaService.borrarDetalleVenta(codigo);
        return ResponseEntity.ok().build();
    }   
}
