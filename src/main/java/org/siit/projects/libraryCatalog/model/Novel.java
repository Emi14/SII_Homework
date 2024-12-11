package org.siit.projects.libraryCatalog.model;

import org.siit.projects.libraryCatalog.enums.BookType;

public class Novel extends Book{

    private BookType bookType;

    public Novel(String name, int numberOfPages, BookType bookType) {
        super(name, numberOfPages);
        this.bookType = bookType;
    }


    @Override
    public String toString() {
        return "\nName: '" + name + '\'' +
                "\nNumber of pages: " + numberOfPages +
                "\nBook type: " + bookType;
    }
}
