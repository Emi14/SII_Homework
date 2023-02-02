package org.siit.homework.week10;

public class Festival {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();
        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.values()[(int)(Math.random() * TicketType.values().length)];
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }
    }
}