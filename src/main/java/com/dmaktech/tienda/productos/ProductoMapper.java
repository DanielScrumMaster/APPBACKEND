package com.dmaktech.tienda.productos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.Collectors;

import com.dmaktech.tienda.exceptions.CSVFileException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

public class ProductoMapper {

    public static Collection<Producto> csvToProducts(MultipartFile file) {

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
                CSVParser productosCSV = CSVFormat
                    .Builder
                    .create(CSVFormat.DEFAULT)
                    .setHeader("codigo", "nombre", "nitProveedor", "precioCompra", "iva", "precioVenta")
                    .build()
                    .parse(reader)
            ) 
        {                            
            return productosCSV
                .stream()
                .map(registro -> {
                    return new Producto(
                        Long.parseLong(registro.get("codigo")),
                        registro.get("nombre"),
                        Double.parseDouble(registro.get("iva")),
                        Long.parseLong(registro.get("nitProveedor")),
                        Double.parseDouble(registro.get("precioCompra")),
                        Double.parseDouble(registro.get("precioVenta")));
                })
                .collect(Collectors.toList());

        } catch (Exception e) {            
            throw new CSVFileException("No se pudo procesar el archivo CSV: " + e.getMessage());
        }
    }
}
