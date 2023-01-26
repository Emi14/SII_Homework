package org.siit.homework.week10;

import java.util.concurrent.atomic.AtomicInteger;

class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;
    private AtomicInteger full = new AtomicInteger();
    private AtomicInteger fullVip = new AtomicInteger();
    private AtomicInteger freePass = new AtomicInteger();
    private AtomicInteger oneDay = new AtomicInteger();
    private AtomicInteger oneDayVip = new AtomicInteger();

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!gate.getTickets().isEmpty()) {
                while (!gate.getTickets().isEmpty()) {
                    TicketType ticket = gate.getTickets().poll();
                    switch (ticket) {
                        case FULL:
                            full.incrementAndGet();
                            break;
                        case FULL_VIP:
                            fullVip.incrementAndGet();
                            break;
                        case FREE_PASS:
                            freePass.incrementAndGet();
                            break;
                        case ONE_DAY:
                            oneDay.incrementAndGet();
                            break;
                        case ONE_DAY_VIP:
                            oneDayVip.incrementAndGet();
                            break;
                    }
                }
                System.out.println("Full:"+full.get());
                System.out.println("Full VIP: " + fullVip.get());
                System.out.println("Free Pass: " + freePass.get());
                System.out.println("One Day: " + oneDay.get());
                System.out.println("One Day VIP: " + oneDayVip.get());
            }
        }
    }
}