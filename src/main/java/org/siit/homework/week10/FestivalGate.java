package org.siit.homework.week10;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final Queue<TicketType> tickets = new ConcurrentLinkedQueue<>();

    public void validateTicket(TicketType ticketType) {
        tickets.add(ticketType);
    }

    public Queue<TicketType> getTickets() {
        return tickets;
    }
}