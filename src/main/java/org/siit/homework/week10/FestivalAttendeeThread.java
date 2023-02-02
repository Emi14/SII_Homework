package org.siit.homework.week10;

class FestivalAttendeeThread extends Thread {
    private TicketType ticket;
    private FestivalGate gate;
    public FestivalAttendeeThread(TicketType ticket, FestivalGate gate) {
        this.ticket = ticket;
        this.gate = gate;
    }
    public void run() {
        gate.validateTicket(ticket);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}