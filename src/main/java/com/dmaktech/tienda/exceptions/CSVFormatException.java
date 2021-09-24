package com.dmaktech.tienda.exceptions;

public class CSVFormatException extends RuntimeException{

    private String errorMessage;

    public CSVFormatException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getCsvName() {
        return errorMessage;
    }
}
