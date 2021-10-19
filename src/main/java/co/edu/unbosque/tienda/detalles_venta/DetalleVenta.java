package co.edu.unbosque.tienda.detalles_venta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle")
    private Long codigoDetalle;
    
    @Column(name = "codigo_venta")
    private Long codigoVenta;

    @Column(name = "codigo_producto")
    private Long codigoProducto;

    @Column(name = "cantidad_producto")
    private Long cantidadProducto;

    @Column(name = "val_venta")
    private Double valorUnitario;

    @Column(name = "val_total")
    private Double valorTotal;

    @Column(name = "val_iva")
    private Double valorIva;

    public Long getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(Long codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public Long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Long getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    
}
