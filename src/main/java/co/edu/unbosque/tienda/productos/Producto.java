package co.edu.unbosque.tienda.productos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "productos")
public class Producto {
    
    @Id
    @Column(name = "cod_producto")
    private Long codigo;
    
    @Column(name = "nom_producto")
    private String nombre;    

    @Column(name = "iva_compra")
    private Double iva;

    @Column(name = "nit_proveedor")
    private Long nitProveedor;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    public Producto() {}

    public Producto(Long codigo, String nombre, Double iva, Long nitProveedor, Double precioCompra,
            Double precioVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.iva = iva;
        this.nitProveedor = nitProveedor;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", iva=" + iva + ", nitProveedor=" + nitProveedor + ", nombre=" + nombre
                + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + "]";
    }
}
