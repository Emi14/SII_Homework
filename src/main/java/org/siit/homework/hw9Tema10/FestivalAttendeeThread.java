package org.siit.homework.hw9Tema10;

public class FestivalAttendeeThread extends Thread {

    private final TicketType ticketType;
    private final FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        festivalGate.add(ticketType);
    }
}
