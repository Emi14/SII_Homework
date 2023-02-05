package org.siit.homework.week10;

public class FestivalStatistics implements Runnable{
    private Gate gate;
    private int totalAttendees;

    FestivalStatistics(Gate gate, int totalAttendees){
        this.gate = gate;
        this.totalAttendees = totalAttendees;
    }


    @Override
    public void run() {
        do {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gate.printStatistics();

        } while(gate.getCounterTotalAttendees() < totalAttendees);
    }
}
