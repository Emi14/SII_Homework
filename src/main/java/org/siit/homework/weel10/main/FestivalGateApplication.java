package org.siit.homework.weel10.main;

import org.siit.homework.weel10.thread.FestivalAttendeeThread;
import org.siit.homework.weel10.gate.FestivalGate;
import org.siit.homework.weel10.statistics.FestivalStatisticsThread;
import org.siit.homework.weel10.enums.TicketType;

import java.util.Random;

public class FestivalGateApplication {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 10 homework");
        System.out.println();

        FestivalGate gate = new FestivalGate();

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = getRandomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();
    }

    private static TicketType getRandomTicketType() {
        Random random = new Random();
        int ticketTypeIndex = random.nextInt(TicketType.values().length);
        return TicketType.values()[ticketTypeIndex];
    }
}

