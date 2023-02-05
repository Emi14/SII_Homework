package org.siit.homework.week10;

public class Festival {

    public static void main(String[] args) {
        Gate gate = new Gate();
        int attendees = 1000;

        Thread statistics =  new Thread(new FestivalStatistics(gate,attendees));
        statistics.start();

        for(int i=0; i<attendees;i++) {
            new Thread(new Person(gate)).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
