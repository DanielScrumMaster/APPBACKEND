package co.edu.unbosque.tienda.exceptions;

public class CSVFileException extends RuntimeException{

    private String errorMessage;

    public CSVFileException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getCsvName() {
        return errorMessage;
    }
}
