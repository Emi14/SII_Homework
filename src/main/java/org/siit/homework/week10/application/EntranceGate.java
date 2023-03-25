package org.siit.homework.week10.application;

import org.siit.homework.week10.enums.TicketType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntranceGate {

    private final List<TicketType> ticketTypeList = Collections.synchronizedList(new ArrayList<>());

    public List<TicketType> getTicketTypeList() {
        return ticketTypeList;
    }

    public void validateTicket(TicketType ticketType) {
        ticketTypeList.add(ticketType);
    }
}
