package org.siit.homework.week10.algorithm;

import org.siit.homework.week10.enums.TicketType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FestivalStatisticThread implements Runnable {
    private final Gate gate;
    public static final int MAX_CAPACITY = 100;

    public FestivalStatisticThread(Gate gate) {
        this.gate = gate;
    }


    @Override
    public void run() {
        for (int total = 0; total < MAX_CAPACITY;) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<TicketType> ticketTypeList = gate.getTicketTypeList();
            Map<TicketType, Long> ticketCounts = ticketTypeList.stream()
                    .collect(Collectors.groupingBy(elem -> elem, Collectors.counting()));
            total = ticketTypeList.size();
            System.out.println(ticketCounts + " TOTAL: " + total);
        }
    }
}
