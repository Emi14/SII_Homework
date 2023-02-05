package org.siit.homework.week10;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    public static TicketType randomTicketType()  {
        Random rand = new Random();
        TicketType[] ticketTypes = values();
        TicketType randomTicketType = ticketTypes[rand.nextInt(ticketTypes.length)];
        return randomTicketType;
    }
}
