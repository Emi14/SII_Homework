package org.siit.homework.week4.tema41.lg;

import org.siit.homework.week4.tema41.Phone;

public abstract class LG extends Phone {
    public LG(int batteryLife) {
        super(batteryLife);
    }

    @Override
    public String toString() {
        return "LG " + super.toString();
    }
}
