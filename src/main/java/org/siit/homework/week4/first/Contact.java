package org.siit.homework.week4.first;

public class Contact {

    int place;
    String phoneNumber;
    String firstName;
    String lastName;

    Message firstMessage;
    Message lastMessage;

    public Contact(int place, String phoneNumber, String firstName, String lastName) {
        this.place = place;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Place: " + this.place + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "First name: " + this.firstName + "\n" +
                "Last name: " + this.lastName + "\n";
    }
}
