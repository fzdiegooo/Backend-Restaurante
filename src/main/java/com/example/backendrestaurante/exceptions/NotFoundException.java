package com.example.backendrestaurante.exceptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 5617542433839394135L;

    public NotFoundException(final String message) {
        super(message);
    }
}
