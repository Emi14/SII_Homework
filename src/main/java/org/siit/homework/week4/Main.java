package org.siit.homework.week4;

import org.siit.homework.week4.enums.BookType;
import org.siit.homework.week4.enums.PaperQuality;
import org.siit.homework.week4.model.ArtAlbum;
import org.siit.homework.week4.model.Book;
import org.siit.homework.week4.model.Novel;
import org.siit.homework.week4.service.ILibraryCatalog;
import org.siit.homework.week4.service.LibraryCatalogImpl;


public class Main {

    public static final ILibraryCatalog libraryCatalog = new LibraryCatalogImpl();

    public static void main(String[] args) {

        Book book1 = new ArtAlbum("DaVinci", 60, PaperQuality.GLOSSY);
        Book book2 = new Novel("Casa cu scari", 250, BookType.CRIME);
        Book book3 = new Novel("Maytrei", 340, BookType.ROMANCE);

        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
        libraryCatalog.addBook(book3);

        libraryCatalog.listAllBooks();
        System.out.println("\n---------------------");

        libraryCatalog.deleteBook(book1);
        System.out.println("---------------------");

         libraryCatalog.listAllBooks();




    }
}
