package org.siit.homework.week10;

import org.siit.homework.week10.application.EntranceGate;
import org.siit.homework.week10.application.FestivalAtendeesThread;
import org.siit.homework.week10.application.FestivalStatisticThread;

public class MainWeek10 {

    public static void main(String[] args) {
        EntranceGate entranceGate = new EntranceGate();
        Thread statisticsThread = new Thread(new FestivalStatisticThread(entranceGate));
        statisticsThread.start();
        for (int i = 0; i < FestivalStatisticThread.MAX_CAPACITY; ++i) {
            new Thread(new FestivalAtendeesThread(entranceGate)).start();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
