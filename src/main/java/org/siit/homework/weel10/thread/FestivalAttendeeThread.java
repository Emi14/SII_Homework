package org.siit.homework.weel10.thread;

import org.siit.homework.weel10.gate.FestivalGate;
import org.siit.homework.weel10.enums.TicketType;

public class FestivalAttendeeThread extends Thread{
    private TicketType ticket;
    private FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticket, FestivalGate gate) {
        this.ticket = ticket;
        this.gate = gate;
    }

    @Override
    public void run() {
        gate.validateTicket(ticket);
    }
}
