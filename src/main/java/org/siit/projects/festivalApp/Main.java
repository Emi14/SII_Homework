package org.siit.projects.festivalApp;


public class Main {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();

        Thread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();

        for(int i = 0; i < 500; i++) {
            Runnable attendee = new FestivalAttendeeThread(gate);
            Thread attendeeThread = new Thread(attendee);
            attendeeThread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

