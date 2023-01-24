package org.siit.homework.week10;

public class FestivalAttendeeThread extends Thread {
        private final TicketType ticketType;
        private final FestivalGate gate;

        public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
            this.ticketType = ticketType;
            this.gate = gate;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gate.validateTicket(ticketType);
        }
    }


