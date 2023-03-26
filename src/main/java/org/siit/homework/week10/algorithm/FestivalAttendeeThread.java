package org.siit.homework.week10.algorithm;

import org.siit.homework.week10.enums.TicketType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FestivalAttendeeThread implements Runnable {
    private final Gate gate;
    private final TicketType ticketType;
    private final Random random = new Random();
    private final List<TicketType> ticketTypeList = Arrays.asList(TicketType.values());

    public FestivalAttendeeThread(Gate gate) {
        this.gate = gate;
        this.ticketType = ticketTypeList.get(random.nextInt(ticketTypeList.size()));
    }

    @Override
    public void run() {
        gate.validateTicket(ticketType);
    }
}
