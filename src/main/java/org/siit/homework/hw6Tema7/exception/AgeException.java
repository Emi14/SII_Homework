package org.siit.homework.hw6Tema7.exception;

public class AgeException extends RuntimeException {
    private static final String MESSAGE = "Age can't be a negative number";

    public AgeException(){
        super(MESSAGE);
    }
}
