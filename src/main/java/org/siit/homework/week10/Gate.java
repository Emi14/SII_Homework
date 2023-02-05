package org.siit.homework.week10;

public class Gate {
    private int counterFull;
    private int counterFullVip;
    private int counterFreePass;
    private int counterOneDay;
    private int counterOneDayVip;

    private int counterTotalAttendees;

    public synchronized void validateTicket(TicketType ticketType) {
        counterTotalAttendees++;
        switch (ticketType) {
            case FULL:
                counterFull++;
                break;
            case ONE_DAY:
                counterOneDay++;
                break;
            case FULL_VIP:
                counterFullVip++;
                break;
            case FREE_PASS:
                counterFreePass++;
                break;
            case ONE_DAY_VIP:
                counterOneDayVip++;
                break;
        }
    }
    public synchronized void printStatistics() {
        System.out.println("-------------------------------------------");
        System.out.println(counterTotalAttendees + " people entered");
        System.out.println(counterFull + " people have full tickets");
        System.out.println(counterFreePass + " people have free passes");
        System.out.println(counterFullVip + " people have full VIP passes");
        System.out.println(counterOneDay + " people have one day passes");
        System.out.println(counterOneDayVip + " people have one-day VIP passes");
    }

    public int getCounterTotalAttendees() {
        return counterTotalAttendees;
    }
}
