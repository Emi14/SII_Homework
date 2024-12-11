package org.siit.projects.phoneApp;

public interface Phone {

    void addContact(String contactIndex, String phoneNumber, String firstName, String lastName);
    void getFirstContact();
    void getLastContact();
    void sendMessage(String phoneNumber, String messageContent);
    void getFirstMessage(String phoneNumber);
    void getSecondMessage(String phoneNumber);
    void call(String phoneNumber);
    void viewHistory();

}
