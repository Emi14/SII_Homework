package org.siit.homework.week4.second;

public class Novel extends Book {

    String type;

    public Novel(String name, int numberOfPages, String type) {
        super(name, numberOfPages);
        this.type = type;
    }

    @Override
    String print() {
        return super.print() + "Type: " + type;
    }
}
