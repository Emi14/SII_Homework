package org.siit.homework.week4.second;


import org.siit.homework.week4.second.enums.PaperQuality;

public class Week4Main {
    public static void main(String[] args) {

        //Creates a new catalog
        LibraryCatalog catalog = new LibraryCatalog();

        //Adds 3 books to the catalog
        Book novel = new Novel("Capra cu 3 iezi", 45, "Basm");
        catalog.addBook(novel);

        Book artAlbum = new ArtAlbum("Poze", 24, PaperQuality.LUSTER_PAPER);
        catalog.addBook(artAlbum);

        Book artAlbum2 = new ArtAlbum("Photos", 38, PaperQuality.DEEP_MATTE);
        catalog.addBook(artAlbum2);

        //Removes all the books from the catalog
        catalog.removeBook(novel);
        catalog.removeBook(artAlbum);
        catalog.removeBook(artAlbum2);

        //Adds another 3 books
        Book novel2 = new Novel("Blahblah", 150, "SF");
        catalog.addBook(novel2);

        Book artAlbum3 = new ArtAlbum("Wedding Pics", 140, PaperQuality.HIGH_GLOSS);
        catalog.addBook(artAlbum3);

        Book novel3 = new Novel("Blahblahblahblah", 458, "Fantasy");
        catalog.addBook(novel3);

        //Lists all the books recently added
        catalog.listBooks();

    }
}
