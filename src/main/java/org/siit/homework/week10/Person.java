package org.siit.homework.week10;

public class Person implements Runnable{

    private TicketType ticketType;
    private Gate gate;

    public Person(Gate gate) {
        ticketType = TicketType.randomTicketType();
        this.gate = gate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public void run() {
        gate.validateTicket(ticketType);

    }
}
