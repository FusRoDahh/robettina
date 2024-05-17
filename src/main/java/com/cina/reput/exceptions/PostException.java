package com.cina.reput.exceptions;

public class PostException extends Exception{

    private int internalCodeError;

    public PostException(String message, int internalCodeError) {
        super(message);
        this.internalCodeError = internalCodeError;
    }
}
