package org.siit.homework.hw9Tema10;

public class Main {
    public static void main(String[] args) {
        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(festivalGate);
        statisticsThread.start();

        for (int i = 0; i < 1000; i++) {
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(TicketType.randomTicket(), festivalGate);
            festivalAttendee.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}