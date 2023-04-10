package org.siit.projects.libraryCatalog.service;
import org.siit.projects.libraryCatalog.model.Book;


public interface ILibraryCatalog {

    void addBook(Book book);
    void deleteBook(Book book);
    void listAllBooks();
}
