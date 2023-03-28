package org.siit.homework.week4.second;


import org.siit.homework.week4.second.enums.PaperQuality;

public class ArtAlbum extends Book {

    PaperQuality quality;

    public ArtAlbum(String name, int numberOfPages, PaperQuality quality) {
        super(name, numberOfPages);
        this.quality = quality;
    }

    @Override
    String print() {
        return super.print() + "Quality: " + quality;
    }
}
