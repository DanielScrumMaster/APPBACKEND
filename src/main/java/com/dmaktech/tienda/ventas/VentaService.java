package com.dmaktech.tienda.ventas;

import java.util.Collection;

import com.dmaktech.tienda.exceptions.VentaNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;

    public Collection<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVenta(Long id) {
        return ventaRepository
            .findById(id)
            .orElseThrow(() -> new VentaNotFoundException(id));
    }

    public void crearVenta(Venta nuevaVenta) {
        ventaRepository.save(nuevaVenta);
    }
}
