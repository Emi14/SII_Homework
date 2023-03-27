package org.siit.homework.week4.second;

public abstract class Book { //Abstract because we don't need to have any Book class instances

    String name;
    int numberOfPages;

    public Book(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    String print() {
        return "Name: " + name + "\n" +
                "Number of pages: " + numberOfPages + "\n";
    }
}
