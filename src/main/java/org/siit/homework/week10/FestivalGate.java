package org.siit.homework.week10;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate  {
    private final Queue<TicketType> ticketQueue;

    public FestivalGate() {
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
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

    public synchronized TicketType getNextTicket() {
        return ticketQueue.poll();
    }

    public synchronized int getTicketsCount() {
        return ticketQueue.size();
    }
}
