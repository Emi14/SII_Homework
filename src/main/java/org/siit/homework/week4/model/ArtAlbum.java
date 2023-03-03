package org.siit.homework.week4.model;

import org.siit.homework.week4.enums.PaperQuality;

public class ArtAlbum extends Book {

    private PaperQuality paperQuality;

    public ArtAlbum(String name, int numberOfPages, PaperQuality paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "\nName: '" + name + '\'' +
                "\nNumber of pages: " + numberOfPages +
                "\nPaper quality: " + paperQuality;
    }
}
