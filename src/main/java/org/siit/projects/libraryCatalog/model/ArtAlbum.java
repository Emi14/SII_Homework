package org.siit.projects.libraryCatalog.model;

import org.siit.projects.libraryCatalog.enums.PaperQuality;

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
