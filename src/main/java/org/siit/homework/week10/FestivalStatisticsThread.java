package org.siit.homework.week10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FestivalStatisticsThread extends Thread{

    FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
            this.gate = gate;
    }

    @Override
    public void run() {
        int total = 0;
        while (total < 500) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            List<TicketType> tickets = gate.getTickets();
            total = tickets.size();

            Map<TicketType, Long> ticketTypeCount = tickets.stream()
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            System.out.println(total + " people entered.");
            System.out.println(ticketTypeCount);

        }
    }

}
