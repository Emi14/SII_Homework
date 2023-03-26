package org.siit.homework.hw6Tema7.exception;

public class LastNameException extends RuntimeException {
    private static final String MESSAGE = "Last Name should not be empty.";

    public LastNameException() {
        super(MESSAGE);
    }

}
