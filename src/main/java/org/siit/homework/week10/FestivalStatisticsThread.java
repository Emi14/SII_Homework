package org.siit.homework.week10;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private final long startTime;
    private boolean queueEmpty = false;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            int totalProcessed = 0;
            while (true) {
                Thread.sleep(5000);
                int intervalProcessed = 0;
                int totalTickets = gate.getTicketsCount();
                if (totalTickets == 0) {
                    if (queueEmpty) {
                        System.out.println("No attendees yet.");
                    } else {
                        queueEmpty = true;
                        System.out.println("Waiting for more attendees...");
                    }
                } else {
                    queueEmpty = false;
                    int fullTickets = 0, fullVipTickets = 0, freePassTickets = 0, oneDayTickets = 0, oneDayVipTickets = 0;
                    for (int i = 0; i < Math.min(totalTickets, 100); i++) {
                        TicketType ticket = gate.getNextTicket();
                        switch (ticket)
                        {
                            case FULL:
                                fullTickets++;
                                break;
                            case FULL_VIP:
                                fullVipTickets++;
                                break;
                            case FREE_PASS:
                                freePassTickets++;
                                break;
                            case ONE_DAY:
                                oneDayTickets++;
                                break;
                            case ONE_DAY_VIP:
                                oneDayVipTickets++;
                                break;
                        }
                        intervalProcessed++;
                        totalProcessed++;
                    }
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    System.out.println("After " + elapsedTime / 1000 + " seconds:");
                    System.out.println(totalProcessed + " people entered");
                    System.out.println(fullTickets + " have full tickets");
                    System.out.println(fullVipTickets + " have full VIP passes");
                    System.out.println(freePassTickets + " have free passes");
                    System.out.println(oneDayTickets + " have one-day passes");
                    System.out.println(oneDayVipTickets + " have one-day VIP passes");
                }
                System.out.println(intervalProcessed + " people processed in the last 5 seconds.");
                intervalProcessed = 0;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
