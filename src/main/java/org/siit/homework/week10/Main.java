import org.siit.homework.week10.FestivalGate;
import org.siit.homework.week10.FestivalStatisticsThread;
import org.siit.homework.week10.TicketType;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = getRandomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }
    }

    private static TicketType getRandomTicketType() {
        TicketType[] values = TicketType.values();
        int index = new Random().nextInt(values.length);
        return values[index];
    }

    private static class FestivalAttendeeThread {
        public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {

        }

        public void start() {

        }
    }
}