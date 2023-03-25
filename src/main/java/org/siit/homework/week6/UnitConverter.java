package org.siit.homework.week6;

public enum UnitConverter {

    km(1000000),
    m(1000),
    dm(100),
    cm(10),
    mm(1);


    private final int unit;

    UnitConverter(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
