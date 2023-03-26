package org.siit.homework.hw6Tema7.exception;

public class GenderException extends RuntimeException {
    private static final String MESSAGE = "Gender should be male of female (M/F). Upper/lower case accepted.";
    public GenderException(){
        super(MESSAGE);
    }
}
