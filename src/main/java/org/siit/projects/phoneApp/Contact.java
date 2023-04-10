package org.siit.projects.phoneApp;

public class Contact {
    String contactIndex;
    String phoneNumber;
    String firstName;
    String lastName;

    public Contact(String contactIndex, String phoneNumber, String firstName, String lastName) {
        this.contactIndex = contactIndex;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "contactIndex='" + contactIndex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
