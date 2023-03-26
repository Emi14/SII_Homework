package org.siit.homework.week4.second;

public class LibraryCatalog {

    private Book firstBook;
    private Book secondBook;
    private Book thirdBook;

    /**
     * Verifies if the Book fields are occupied, and if not assigns the parameter to one of the fields.
     * @param book is the book which we want to add
     */
    void addBook(Book book) {
        if (firstBook == null) {
            firstBook = book;
        } else if (secondBook == null) {
            secondBook = book;
        } else if (thirdBook == null) {
            thirdBook = book;
        } else {
            System.out.println("Out of memory!");
        }
    }

    /**
     * Checks if the field is null, and if not and also the parameter complies the condition assigns null to the field.
     * @param book is the book which we want to remove
     */
    void removeBook(Book book) {
        if (firstBook != null && book.name.compareTo(firstBook.name) == 0) {
            firstBook = null;
        } else if (secondBook != null && book.name.compareTo(secondBook.name) == 0) {
            secondBook = null;
        } else if (thirdBook != null && book.name.compareTo(thirdBook.name) == 0) {
            thirdBook = null;
        } else {
            System.out.println("Book not found!");
        }
    }

    /**
     * List all the books one by one
     */
    void listBooks() {
        if (firstBook != null) {
            System.out.println(firstBook.print());
        }
        if (secondBook != null) {
            System.out.println(secondBook.print());
        }
        if (thirdBook != null) {
            System.out.println(thirdBook.print());
        }
    }



}
