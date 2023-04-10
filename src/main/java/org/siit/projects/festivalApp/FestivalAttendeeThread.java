package org.siit.projects.festivalApp;

import java.util.Random;

public class FestivalAttendeeThread implements Runnable{

    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(FestivalGate gate) {
        this.ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
        this.gate = gate;
    }

    @Override
    public void run() {
        gate.validateTicket(ticketType);
    }
}
