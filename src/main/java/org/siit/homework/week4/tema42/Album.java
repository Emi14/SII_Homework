package org.siit.homework.week4.tema42;

public class Album extends Book{
    private String paperQuality;
    public Album(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "Album{" +
                "paperQuality='" + paperQuality + '\'' +
                "} " + super.toString();
    }
}
