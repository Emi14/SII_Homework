package org.siit.homework.week4.service;
import org.siit.homework.week4.model.Book;


public interface ILibraryCatalog {

    void addBook(Book book);
    void deleteBook(Book book);
    void listAllBooks();
}
