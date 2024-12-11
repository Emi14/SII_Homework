package org.siit.projects.libraryCatalog.service;
import org.siit.projects.libraryCatalog.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalogImpl implements ILibraryCatalog {

    List<Book> books;


    public LibraryCatalogImpl() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println(book.getName() + " was removed from the list.");
    }

    @Override
    public void listAllBooks() {
        for(Book book: books){
            System.out.println(book);
        }
    }
}
