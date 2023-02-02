package org.siit.homework.week10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Ticket
{
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final List<Ticket> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Ticket randomTicket()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }


}
