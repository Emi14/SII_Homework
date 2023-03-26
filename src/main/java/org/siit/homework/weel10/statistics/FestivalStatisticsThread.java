package org.siit.homework.weel10.statistics;

import org.siit.homework.weel10.gate.FestivalGate;
import org.siit.homework.weel10.enums.TicketType;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread{
    private FestivalGate gate;
    private volatile boolean running = true;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        int totalEntered = 0;
        int fullCount = 0;
        int fullVipCount = 0;
        int freePassCount = 0;
        int oneDayCount = 0;
        int oneDayVipCount = 0;

        while (running) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Queue<TicketType> ticketQueue = gate.getTicketQueue();
            int entered = ticketQueue.size();
            totalEntered += entered;

            for (TicketType ticket : ticketQueue) {
                switch (ticket) {
                    case FULL:
                        fullCount++;
                        break;
                    case FULL_VIP:
                        fullVipCount++;
                        break;
                    case FREE_PASS:
                        freePassCount++;
                        break;
                    case ONE_DAY:
                        oneDayCount++;
                        break;
                    case ONE_DAY_VIP:
                        oneDayVipCount++;
                        break;
                }
            }

            System.out.println(entered + " people entered\n" +
                    fullCount + " have full tickets\n" +
                    freePassCount + " have free passes\n" +
                    fullVipCount + " have full VIP passes\n" +
                    oneDayCount + " have one-day passes\n" +
                    oneDayVipCount + " have one-day VIP passes\n" +
                    "Total entered: " + totalEntered + "\n");
        }
    }
}
