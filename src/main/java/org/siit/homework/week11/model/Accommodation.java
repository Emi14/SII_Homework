package org.siit.homework.week11.model;

import java.util.ArrayList;
import java.util.List;

public class Accommodation {
    private int id;
    private String type;
    private String bed_type;
    private int max_guests;
    private String description;

    private List<Fare> fares = new ArrayList<>();

    public Accommodation(int id, String type, String bed_type, int max_guests, String description) {
        this.id = id;
        this.type = type;
        this.bed_type = bed_type;
        this.max_guests = max_guests;
        this.description = description;
    }

    public Accommodation(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBed_type() {
        return bed_type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public int getMax_guests() {
        return max_guests;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Fare> getFares() {
        return fares;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bed_type='" + bed_type + '\'' +
                ", max_guests=" + max_guests +
                ", description='" + description + '\'' +
                ", fares=" + fares +
                '}';
    }
}
