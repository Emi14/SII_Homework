package org.siit.homework.hw9Tema10;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final Random random = new Random();

    public static TicketType randomTicket() {
        TicketType[] ticket = values();
        return ticket[random.nextInt(ticket.length)];
    }
}
