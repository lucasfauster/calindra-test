package com.calindra.test.exceptions;

public class InvalidAddressException extends Exception {
    public InvalidAddressException(String errorMessage) {
        super(errorMessage);
    }
}
