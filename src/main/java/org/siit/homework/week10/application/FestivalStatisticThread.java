package org.siit.homework.week10.application;

import org.siit.homework.week10.enums.TicketType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FestivalStatisticThread implements Runnable{

    private final EntranceGate entranceGate;
    public static final int MAX_CAPACITY = 100;

    public FestivalStatisticThread(EntranceGate entranceGate) {
        this.entranceGate = entranceGate;
    }


    @Override
    public void run() {
        for (int total = 0; total < MAX_CAPACITY;) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<TicketType> ticketTypeList = entranceGate.getTicketTypeList();
            Map<TicketType, Long> ticketCounts = ticketTypeList.stream()
                    .collect(Collectors.groupingBy(elem -> elem, Collectors.counting()));
            total = ticketTypeList.size();
            System.out.println(ticketCounts + " TOTAL: " + total);
        }
    }
}
