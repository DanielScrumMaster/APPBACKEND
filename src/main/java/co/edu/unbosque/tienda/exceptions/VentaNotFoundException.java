package co.edu.unbosque.tienda.exceptions;

public class VentaNotFoundException extends RuntimeException{
    
    private Long id;

    public VentaNotFoundException(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

}
