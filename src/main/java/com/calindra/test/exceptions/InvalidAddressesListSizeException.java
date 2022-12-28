package com.calindra.test.exceptions;

public class InvalidAddressesListSizeException extends Exception {
    public InvalidAddressesListSizeException(String errorMessage) {
        super(errorMessage);
    }
}
