package org.siit.projects.libraryCatalog.model;


public abstract class Book {

    String name;
    int numberOfPages;

    public Book(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }
}

