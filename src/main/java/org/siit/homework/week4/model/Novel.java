package org.siit.homework.week4.model;

import org.siit.homework.week4.enums.BookType;

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
