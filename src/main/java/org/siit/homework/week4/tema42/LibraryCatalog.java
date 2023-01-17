package org.siit.homework.week4.tema42;

public class LibraryCatalog {
    private Book book1;
    private Book book2;
    private Book book3;

    public void addBook1(Book book) {
        this.book1 = book;
    }
    public void addBook2(Book book) {
        this.book2 = book;
    }
    public void addBook3(Book book) {
        this.book3 = book;
    }
    public void deleteBook3() {
        this.book3 = null;
    }
    public void listBooks() {
        if (book1 != null) {
            System.out.println("Book1 = " + book1);
        }
        if (book2 != null) {
            System.out.println("Book2 = " + book2);
        }
        if (book3 != null) {
            System.out.println("Book3 = " + book3);
        }
    }


}
