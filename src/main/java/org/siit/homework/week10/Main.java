package org.siit.homework.week10;

import org.siit.homework.week10.algorithm.FestivalAttendeeThread;
import org.siit.homework.week10.algorithm.FestivalStatisticThread;
import org.siit.homework.week10.algorithm.Gate;

public class Main {
    public static void main(String[] args) {
        Gate gate = new Gate();
        Thread statisticsThread = new Thread(new FestivalStatisticThread(gate));
        statisticsThread.start();
        for (int i = 0; i < FestivalStatisticThread.MAX_CAPACITY; ++i) {
            new Thread(new FestivalAttendeeThread(gate)).start();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
