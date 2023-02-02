package org.siit.homework.week6.example;

public class Calculator {
    private int mm;
    private int cm;
    private int dm;
    private int m;
    private int km;


    public Calculator(int mm, int cm, int dm, int m, int km) {
        this.mm = mm;
        this.cm = cm;
        this.dm = dm;
        this.m = m;
        this.km = km;
    }

    public Calculator() {
        this.mm = 0;
        this.cm = 0;
        this.dm = 0;
        this.m = 0;
        this.km = 0;
    }

    public void add(int value, String unitateDeMasura) {
        if (unitateDeMasura.equals("mm")) {
            this.mm += value;

        }
        if (unitateDeMasura.equals("cm")) {
            this.cm += value;

        }
        if (unitateDeMasura.equals("dm")) {
            this.dm += value;

        }
        if (unitateDeMasura.equals("m")) {
            this.m += value;

        }
        if (unitateDeMasura.equals("km")) {
            this.km += value;

        }
    }

    public void sub(int value, String unitateDeMasura) {
        if (unitateDeMasura.equals("mm")) {
            this.mm -= value;

        }
        if (unitateDeMasura.equals("cm")) {
            this.cm -= value;

        }
        if (unitateDeMasura.equals("dm")) {
            this.dm -= value;

        }
        if (unitateDeMasura.equals("m")) {
            this.m -= value;

        }
        if (unitateDeMasura.equals("km")) {
            this.km -= value;

        }
    }

    public int getResult() {

        int variabila = mm + cm * 10 + dm * 100 + m * 1000 + km * 1000000;
        return variabila;
    }

    public void expression(String string) {

        String[] stringulVector = string.split(" ");
        //10 cm + 1 m +10mm + 20 km + 15 m + 2 mm

        if (!stringulVector[0].equals("+") || !stringulVector[0].equals("-")) {
            add(Integer.parseInt(stringulVector[0]), stringulVector[1]);
            for (int i = 2; i < stringulVector.length; i += 3) {
                if (stringulVector[i].equals("+")) {
                    add(Integer.parseInt(stringulVector[i + 1]), stringulVector[i + 2]);
                }
                if (stringulVector[i].equals("-")) {
                    sub(Integer.parseInt(stringulVector[i + 1]), stringulVector[i + 2]);
                }
            }
        }
        else {
            for (int i = 0; i < stringulVector.length; i += 3) {
                if (stringulVector[i].equals("+")) {
                    add(Integer.parseInt(stringulVector[i + 1]), stringulVector[i + 2]);
                }
                if (stringulVector[i].equals("-")) {
                    sub(Integer.parseInt(stringulVector[i + 1]), stringulVector[i + 2]);
                }
            }
        }

    }


}
