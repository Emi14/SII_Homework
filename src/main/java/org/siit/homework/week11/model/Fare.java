package org.siit.homework.week11.model;

public class Fare {
    private int id;
    private double valueEUR;
    private String season;

    public Fare(int id, double valueEUR, String season) {
        this.id = id;
        this.valueEUR = valueEUR;
        this.season = season;
    }

    public Fare(double valueEUR, String season) {
        this.valueEUR = valueEUR;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValueEUR() {
        return valueEUR;
    }

    public void setValueEUR(double valueEUR) {
        this.valueEUR = valueEUR;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "id=" + id +
                ", value_eur='" + valueEUR + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
