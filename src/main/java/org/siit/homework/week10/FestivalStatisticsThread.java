package org.siit.homework.week10;

import java.util.EnumMap;
import java.util.Map;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<TicketType, Integer> stats = new EnumMap<>(TicketType.class);
            for (TicketType ticketType : TicketType.values()) {
                stats.put(ticketType, 0);
            }
            for (TicketType ticketType : gate.getTickets()) {
                stats.put(ticketType, stats.get(ticketType) + 1);
            }
            System.out.println("Festival statistics:");
            for (Map.Entry<TicketType, Integer> entry : stats.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

