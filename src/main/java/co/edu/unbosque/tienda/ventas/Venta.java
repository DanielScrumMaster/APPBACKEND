package co.edu.unbosque.tienda.ventas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.edu.unbosque.tienda.detalles_venta.DetalleVenta;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cedula_cliente")
    private Long cedulaCliente;
    @Column(name = "cedula_usuario")
    private Long cedulaUsuario;
    @Column(name = "valor_inicial")
    private Double valorInicial;
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "iva")
    private Double iva;

    @OneToMany(mappedBy = "venta")    
    @JsonManagedReference
    private List<DetalleVenta> detallesVenta;
    
    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Long getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(Long cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Venta [cedulaCliente=" + cedulaCliente + ", cedulaUsuario=" + cedulaUsuario + ", detallesVenta="
                + detallesVenta + ", id=" + id + ", iva=" + iva + ", valorInicial=" + valorInicial + ", valorTotal="
                + valorTotal + "]";
    }  
}
