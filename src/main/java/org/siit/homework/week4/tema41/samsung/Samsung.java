package org.siit.homework.week4.tema41.samsung;


import org.siit.homework.week4.tema41.Phone;

public abstract class Samsung extends Phone {
    public Samsung(int batteryLife) {
        super(batteryLife);

    }

    @Override
    public String toString() {
        return "Samsung " + super.toString();
    }
}
