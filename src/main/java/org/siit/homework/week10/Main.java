package org.siit.homework.week10;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();

        Random random = new Random();
        while (true) {
            for (int i = 0; i < 100; i++) {
                TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
                FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
                attendee.start();
            }
            Thread.sleep(5000);
            synchronized(gate) {
                gate.notifyAll();
            }
        }
    }
    }

