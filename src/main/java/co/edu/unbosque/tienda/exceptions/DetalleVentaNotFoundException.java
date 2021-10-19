package co.edu.unbosque.tienda.exceptions;

public class DetalleVentaNotFoundException extends RuntimeException{

    private Long codigo;

    public DetalleVentaNotFoundException(Long codigo) {
        super("No se encontró el detalle venta con código " + codigo);
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
