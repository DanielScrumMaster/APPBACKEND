package com.dmaktech.tienda.productos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.Collectors;

import com.dmaktech.tienda.exceptions.CSVFormatException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class ProductoMapper {

    public static Collection<Producto> csvToProducts(InputStream input) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                CSVParser productosCSV = CSVFormat.Builder.create(CSVFormat.DEFAULT)
                        .setHeader("codigo", "nombre", "nitProveedor", "precioCompra", "iva", "precioVenta").build()
                        .parse(reader)) {                            
            return productosCSV.stream().map(registro -> {
                return new Producto(Long.parseLong(registro.get("codigo")), registro.get("nombre"),
                        Double.parseDouble(registro.get("iva")), Long.parseLong(registro.get("nitProveedor")),
                        Double.parseDouble(registro.get("precioCompra")),
                        Double.parseDouble(registro.get("precioVenta")));
            }).collect(Collectors.toList());

        } catch (Exception e) {            
            throw new CSVFormatException("No se pudo procesar el archivo csv: " + e.getMessage());
        }
    }
}
