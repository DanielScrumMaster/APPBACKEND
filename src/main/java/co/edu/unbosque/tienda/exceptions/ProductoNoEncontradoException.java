package co.edu.unbosque.tienda.exceptions;

public class ProductoNoEncontradoException extends RuntimeException {
    private Long codigo;

    public ProductoNoEncontradoException(Long codigo) {
        super("No se encontró el producto con código " + codigo);
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }
}
