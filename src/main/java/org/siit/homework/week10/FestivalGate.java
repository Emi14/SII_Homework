package org.siit.homework.week10;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class FestivalGate {
    private Queue<TicketType> tickets = new ConcurrentLinkedQueue<>();
    public void validateTicket(TicketType ticket) {
        tickets.offer(ticket);
    }
    public Queue<TicketType> getTickets() {
        return tickets;
    }
}
