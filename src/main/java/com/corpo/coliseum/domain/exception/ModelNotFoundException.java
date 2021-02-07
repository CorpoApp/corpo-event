package com.corpo.coliseum.domain.exception;

public class ModelNotFoundException extends Exception{

    public ModelNotFoundException(String message, Class modelClass) {
        super(message);
    }

}
