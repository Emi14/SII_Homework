package org.siit.homework.hw6Tema7.exception;

public class StudentNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Student does not exist.";
    public StudentNotFoundException(){
        super(MESSAGE);
    }
}
