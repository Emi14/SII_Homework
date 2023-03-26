package org.siit.homework.weel10.gate;

import org.siit.homework.weel10.enums.TicketType;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    private Queue<TicketType> ticketQueue;

    public FestivalGate() {
        ticketQueue = new LinkedList<>();
    }

    public synchronized void validateTicket(TicketType ticket) {
        ticketQueue.add(ticket);
        notifyAll();
    }

    public synchronized Queue<TicketType> getTicketQueue() {
        while (ticketQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ticketQueue;
    }
}
