package org.siit.homework.week10.application;

import org.siit.homework.week10.enums.TicketType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FestivalAtendeesThread implements Runnable{

    private final EntranceGate entranceGate;
    private final TicketType ticketType;
    private final Random random = new Random();
    private final List<TicketType> ticketTypeList = Arrays.asList(TicketType.values());

    public FestivalAtendeesThread(EntranceGate entranceGate) {
        this.entranceGate = entranceGate;
        this.ticketType = ticketTypeList.get(random.nextInt(ticketTypeList.size()));
    }

    @Override
    public void run() {
        entranceGate.validateTicket(ticketType);
    }
}
