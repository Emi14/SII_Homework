package org.siit.homework.hw6Tema7.exception;

public class OrderException extends RuntimeException {
    private static final String MESSAGE = "Order type not specified";
    public OrderException(){
        super(MESSAGE);
    }
}
