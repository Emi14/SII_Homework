package org.siit.homework.hw9Tema10;

import java.util.HashMap;
import java.util.Map;

public class FestivalGate {
    private Map<TicketType, Integer> queue;

    public FestivalGate() {
        init();
    }

    private void init() {
        this.queue = new HashMap<>();
        queue.put(TicketType.FULL, 0);
        queue.put(TicketType.FULL_VIP, 0);
        queue.put(TicketType.FREE_PASS, 0);
        queue.put(TicketType.ONE_DAY, 0);
        queue.put(TicketType.ONE_DAY_VIP, 0);
    }

    public void add(TicketType ticketType) {
        Integer value = queue.get(ticketType);
        queue.put(ticketType, value + 1);
    }

    public Map<TicketType, Integer> getQueue() {
        return queue;
    }
}
