package org.siit.homework.week10;

public class Person extends Thread implements Runnable
{

    FestivalGate festivalGate;
    Ticket ticket;

    public Person(FestivalGate festivalGate, Ticket ticket) {
        this.festivalGate = festivalGate;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        festivalGate.count(ticket);
    }
}
