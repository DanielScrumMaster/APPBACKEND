package co.edu.unbosque.tienda.ventas;

import java.util.Collection;

import co.edu.unbosque.tienda.detalles_venta.DetalleVentaRepository;
import co.edu.unbosque.tienda.exceptions.VentaNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {

  @Autowired
  private VentaRepository ventaRepository;
  @Autowired
  private DetalleVentaRepository detalleVentaRepository;

  public Collection<Venta> getVentas() {
    return ventaRepository.findAll();
  }

  public Venta getVenta(Long id) {
    return ventaRepository
      .findById(id)
      .orElseThrow(() -> new VentaNotFoundException(id));
  }

  public Venta crearVenta(Venta nuevaVenta) {    
    Venta ventaCreada = ventaRepository.save(nuevaVenta);

    detalleVentaRepository.saveAll(nuevaVenta.getDetallesVenta());

    return ventaCreada;
  }

  public Venta actualizarVenta(Long idVenta, Venta ventaActualizada) {
    ventaRepository
            .findById(idVenta)
            .ifPresentOrElse(
                (ventaAntigua) -> {
                    ventaActualizada.setId(idVenta);
                    ventaRepository.save(ventaActualizada);
                }, 
                () -> {
                    throw new VentaNotFoundException(idVenta);
                });
    return ventaActualizada;
  }

  public void borrarVenta(Long idVenta) {
    Venta venta = getVenta(idVenta);
    ventaRepository.delete(venta);
  }
}
