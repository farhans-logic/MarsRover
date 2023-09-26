package org.marsrover.exception;

public class InvalidOrIncompleteDataException extends Exception {

    public static final String ERROR_MESSAGE = "Error: Invalid input data or data is incomplete ";

    public InvalidOrIncompleteDataException(String message) {

        super(ERROR_MESSAGE);
    }

}
