package com.dmaktech.tienda.detalles_venta;

import java.util.Collection;

import com.dmaktech.tienda.exceptions.DetalleVentaNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService {
    
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public Collection<DetalleVenta> getDetallesVentas() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta getDetalleVenta(Long codigo) {
        return detalleVentaRepository
            .findById(codigo)
            .orElseThrow(() -> new DetalleVentaNotFoundException(codigo));
    }

    public void crearDetalleVenta(DetalleVenta detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }

    public void borrarDetalleVenta (Long codigo) {
        DetalleVenta detalle = getDetalleVenta(codigo);
        detalleVentaRepository.delete(detalle);
    }
}
