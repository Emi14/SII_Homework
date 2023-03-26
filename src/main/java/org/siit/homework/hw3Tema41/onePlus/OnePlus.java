package org.siit.homework.hw3Tema41.onePlus;
import org.siit.homework.hw3Tema41.Phone;

public class OnePlus extends Phone {
    public OnePlus(int batteryLife) {
        super(batteryLife);
    }

    @Override
    public String toString() {
        return "One Plus " + super.toString();
    }
}
