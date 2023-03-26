package org.siit.homework.week4.second;


import org.siit.homework.week4.second.enums.PaperQuality;

public class Week4Main {
    public static void main(String[] args) {

        //Creates a new catalog
        LibraryCatalog catalog = new LibraryCatalog();

        //Adds 3 books to the catalog
        Book novel = new Novel("Fat Drumos din Lacrima", 33, "Basm popular");
        catalog.addBook(novel);

        Book artAlbum = new ArtAlbum("Vacanta 2022", 21, PaperQuality.LUSTER_PAPER);
        catalog.addBook(artAlbum);

        Book artAlbum2 = new ArtAlbum("Peisaje", 103, PaperQuality.DEEP_MATTE);
        catalog.addBook(artAlbum2);

        //Removes all the books from the catalog
        catalog.removeBook(novel);
        catalog.removeBook(artAlbum);
        catalog.removeBook(artAlbum2);

        //Adds another 3 books
        Book novel2 = new Novel("Dune", 250, "SF");
        catalog.addBook(novel2);

        Book artAlbum3 = new ArtAlbum("Nunta noastra", 300, PaperQuality.LINEN);
        catalog.addBook(artAlbum3);

        Book novel3 = new Novel("The Mandalorian", 268, "SF");
        catalog.addBook(novel3);

        //Lists all the books recently added
        catalog.listBooks();

    }
}
