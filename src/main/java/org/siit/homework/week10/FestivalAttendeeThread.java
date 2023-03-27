package org.siit.homework.week10;

import java.util.Random;

public class FestivalAttendeeThread extends Thread{
    private final FestivalGate gate;
    private final TicketType ticketType;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            gate.addTicket(ticketType);
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
