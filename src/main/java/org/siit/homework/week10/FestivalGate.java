package org.siit.homework.week10;

import java.util.Random;

public class FestivalGate {

    private int full = 0;
    private int full_vip = 0;
    private int free_pass = 0;
    private int one_day = 0;
    private int one_day_vip = 0;
    private int people = 0;

    public synchronized void count(Ticket ticket)
    {
        people++;

        if(ticket.equals(Ticket.FULL))
        {
            full++;
        }
        if(ticket.equals(Ticket.FREE_PASS))
        {
            free_pass++;
        }
        if(ticket.equals(Ticket.ONE_DAY))
        {
            one_day++;
        }
        if(ticket.equals(Ticket.FULL_VIP))
        {
            full_vip++;
        }
        if(ticket.equals(Ticket.ONE_DAY_VIP))
        {
            one_day_vip++;
        }
        if(ticket.equals(Ticket.FREE_PASS))
        {
            free_pass++;
        }
    }

    public void showStats(){
        System.out.println(getPeople()+" people entered");
        System.out.println(getFull()+" have full tickets");
        System.out.println(getFull_vip()+" have full vip tickets");
        System.out.println(getOne_day()+" have one day tickets");
        System.out.println(getOne_day_vip()+" have one day vip tickets");
        System.out.println(getFree_pass()+" have free tickets");
    }
    public int getPeople() {
        return people;
    }

    public int getFull() {
        return full;
    }


    public int getFull_vip() {
        return full_vip;
    }


    public int getFree_pass() {
        return free_pass;
    }


    public int getOne_day() {
        return one_day;
    }


    public int getOne_day_vip() {
        return one_day_vip;
    }






}
