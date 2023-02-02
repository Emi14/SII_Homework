package org.siit.homework.week10;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {

        int people = 1_000_000;

        List<Thread> threadList = new ArrayList<>();
        FestivalGate festivalGate = new FestivalGate();
        Thread stats = new Stats(festivalGate, people);
        for(long i=0 ;i<people; i++)
        {
            Person t1 = new Person(festivalGate, Ticket.randomTicket());
            threadList.add(t1);
        }


        stats.start();
        for (Thread person : threadList) {
            person.start();
        }


    }

}
