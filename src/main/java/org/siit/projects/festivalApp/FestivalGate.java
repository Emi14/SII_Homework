package org.siit.projects.festivalApp;

import java.util.ArrayList;
import java.util.List;


public class FestivalGate {
    List<TicketType> tickets = new ArrayList<>();

    public synchronized void validateTicket(TicketType ticketType) {

        tickets.add(ticketType);

    }

    public synchronized List<TicketType> getTickets() {
        return tickets;
    }

}
