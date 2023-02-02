package org.siit.homework.week10;

public class Stats extends Thread implements Runnable
{
    FestivalGate festivalGate;
    int people;
    public Stats(FestivalGate festivalGate, int people) {
        this.festivalGate = festivalGate;
        this.people = people;
    }

    @Override
    public void run() {
        try {

            while (festivalGate.getPeople() < people)
            {
                sleep(5000);
                festivalGate.showStats();
                System.out.println("------------------------------------------");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
