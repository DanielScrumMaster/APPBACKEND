package com.dmaktech.tienda.productos;

import java.io.InputStream;
import java.util.Collection;

import com.dmaktech.tienda.exceptions.ProductoNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;

    public Collection<Producto> getProductos(){
        return repository.findAll();
    }

    public Producto getProducto(Long codigo) {
        return repository.findById(codigo)
            .orElseThrow(() -> new ProductoNoEncontradoException(codigo));
    }

    public void guardarProducto(InputStream productosCSV) {
        Collection<Producto> productos = ProductoMapper.csvToProducts(productosCSV);
        repository.deleteAll();
        repository.saveAll(productos);
    }
}
