package org.siit.homework.week8.java;

public class Time {
   private int minut;
    private int secunda;

    public int getMinut() {
        return minut;
    }

    public void setMinut(int minut) {
        this.minut = minut;
    }

    public int getSecunda() {
        return secunda;
    }

    public void setSecunda(int secunda) {
        this.secunda = secunda;
    }

    public Time(int minut, int secunda) {
        this.minut = minut;
        this.secunda = secunda;
    }

    @Override
    public String toString() {
        return minut + ":" + secunda;
    }

    public void aduna(int secunda){
        this.secunda+=secunda;
        minut+=this.secunda/60;
        this.secunda%=60;
    }

    public int compare(Time timpComparat){
        if(minut<timpComparat.getMinut() || (minut==timpComparat.getMinut() && secunda< timpComparat.getSecunda()))
            return -1;
        else if(minut==timpComparat.getMinut() &&  secunda== timpComparat.getSecunda())
            return 0;
        else
            return 1;
    }

}
