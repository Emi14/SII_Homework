package org.siit.homework.week4.first;

import org.siit.homework.week4.first.enums.Material;

public interface Phone {

    void addContact(int place, String phoneNumber, String firstName, String lastName); //Create two contacts per instance
    void getFirstContact();
    void getLastContact();
    void sendMessage(String phoneNumber, String messageContent); //Create two messages per contact
    void getFirstMessage(String phoneNumber);
    void getSecondMessage(String phoneNumber);
    void call(String phoneNumber);
    void viewHistory();
    String toString();
    void setMaterial(Material material);
}
