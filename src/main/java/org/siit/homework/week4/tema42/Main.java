package org.siit.homework.week4.tema42;

public class Main {

//    Create a small application that mimics a library catalog.
//    There are 3 separate Book properties in the LibraryCatalog.
//    It needs to be able to add the 3 books,
//    delete any of the books (set it to null) and list all the books (one by one).
//    Books are of two kinds: novels and art albums. They both have a name and number of pages.
//    Novels have type (like mystery, sf, etc.) while albums have paper quality.
//    Model these entities (book, novel, album) with different classes and inheritance.

    public static void main(String[] args) {

        LibraryCatalog lc = new LibraryCatalog();
        lc.addBook1(new Novel("Harry Poter", 500, "SF"));
        lc.addBook2(new Album("Animals", 50, "Glossy"));
        lc.addBook3(new Novel("Lord of the rings", 1000, "Adventure"));

        System.out.println("\n---------- The books added to the Library Catalog are: ----------");
        lc.listBooks();

        System.out.println("\n---------- The Library Catalog after removing one book contains following: ----------");
        lc.deleteBook3();
        lc.listBooks();
    }
}
