package org.siit.homework.hw9Tema10;

import java.util.Map;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate festivalGate;

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        createStatistics();
        try {
            Thread.sleep(5000);
            this.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void createStatistics() {
        Map<TicketType, Integer> queue = festivalGate.getQueue();
        StringBuilder statistics = new StringBuilder();
        Integer totalAttendees = queue.values().stream()
                .reduce(0, Integer::sum);
        statistics.append(totalAttendees + " people entered.\n");
        for (Map.Entry<TicketType, Integer> entry : queue.entrySet()) {
            statistics.append(entry.getValue() + " people have " + entry.getKey() + " tickets. \n");
        }
        System.out.println(statistics);
    }
}
