package org.siit.homework.week10.algorithm;

import org.siit.homework.week10.enums.TicketType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gate {
    private final List<TicketType> ticketTypeList = Collections.synchronizedList(new ArrayList<>());

    public List<TicketType> getTicketTypeList() {
        return ticketTypeList;
    }

    public void validateTicket(TicketType ticketType) {
        ticketTypeList.add(ticketType);
    }
}
