package org.siit.homework.week8.java;

enum Level {
    WINNER,
    RUNNERUP,
    THIRDPLACE,
}

public class Atlet {
    private int numar;
    private String nume;
    private String codTara;
    private Time timp;
    private String primaAruncare;
    private String aDouaAruncare;
    private String aTreiaAruncare;

    private int penalizare;

    private Time timpFinal;

    private Level level;

    public Atlet(int numar, String nume, String codTara, Time timp, String primaAruncare, String aDouaAruncare, String aTreiaAruncare) {
        this.numar = numar;
        this.nume = nume;
        this.codTara = codTara;
        this.timp = timp;
        this.primaAruncare = primaAruncare;
        this.aDouaAruncare = aDouaAruncare;
        this.aTreiaAruncare = aTreiaAruncare;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCodTara() {
        return codTara;
    }

    public void setCodTara(String codTara) {
        this.codTara = codTara;
    }

    public Time getTimp() {
        return timp;
    }

    public void setTimp(Time timp) {
        this.timp = timp;
    }

    public String getPrimaAruncare() {
        return primaAruncare;
    }

    public void setPrimaAruncare(String primaAruncare) {
        this.primaAruncare = primaAruncare;
    }

    public String getaDouaAruncare() {
        return aDouaAruncare;
    }

    public void setaDouaAruncare(String aDouaAruncare) {
        this.aDouaAruncare = aDouaAruncare;
    }

    public String getaTreiaAruncare() {
        return aTreiaAruncare;
    }

    public void setaTreiaAruncare(String aTreiaAruncare) {
        this.aTreiaAruncare = aTreiaAruncare;
    }

    public Enum getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Atlet{" +
                "numar=" + numar +
                ", nume='" + nume + '\'' +
                ", codTara='" + codTara + '\'' +
                ", timp=" + timp +
                ", primaAruncare='" + primaAruncare + '\'' +
                ", aDouaAruncare='" + aDouaAruncare + '\'' +
                ", aTreiaAruncare='" + aTreiaAruncare + '\'' +
                ", penalizare=" + penalizare +
                ", timpFinal=" + timpFinal +
                '}';
    }

    public void print(){
        switch (this.level){
            case WINNER:
            {System.out.println("Winner" + " -" + this.getNume() + " " + this.getTimpFinal() + " (" + this.getTimp() + " + " + this.getPenalizare() + ")");
                break;}
            case RUNNERUP:
                System.out.println("Runner-up" + " -" + this.getNume() + " " + this.getTimpFinal() + " (" + this.getTimp() + " + " + this.getPenalizare() + ")");
                break;
            case THIRDPLACE:
                System.out.println("Third Place" + " -" + this.getNume() + " " + this.getTimpFinal() + " (" + this.getTimp() + " + " + this.getPenalizare() + ")");
                break;
        }
        //This should fix the issue with the print method and allow it to print out the correct information about the athlete.

           //     I apologize for the confusion in my previous response. Please let me know if you have any other questions or if there is anything else I can help with.





    }

    public int getPenalizare() {
        return penalizare;
    }

    public void setPenalizare(int penalizare) {
        this.penalizare = penalizare;
    }

    public Time getTimpFinal() {
        return timpFinal;
    }

    public void setTimpFinal(Time timpFinal) {
        this.timpFinal = timpFinal;
    }
}
