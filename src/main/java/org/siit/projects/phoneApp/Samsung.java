package org.siit.projects.phoneApp;

import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Samsung implements Phone{
    Color color;
    Material material;
    String imei;

    int batteryLife = 15;
    Contact firstContact;
    Contact lastContact;
    Message message1 = new Message();
    Message message2 = new Message();
    boolean messageSent;
    boolean callMade;

    String callHistory = "\nCall history: \n";


    public Samsung(Color color, Material material, String imei) {
        this.color = color;
        this.material = material;
        this.imei = imei;
    }

    @Override
    public void addContact(String contactIndex, String phoneNumber, String firstName, String lastName) {
        if(contactIndex.equals("1")) {
            firstContact = new Contact(contactIndex, phoneNumber, firstName, lastName);
        } else if (contactIndex.equals("2")) {
            lastContact = new Contact(contactIndex, phoneNumber, firstName, lastName);
        }
    }

    @Override
    public void getFirstContact() {
        System.out.println(firstContact);
    }

    @Override
    public void getLastContact() {
        System.out.println(lastContact);
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        Message message = new Message(messageContent);
        if(message.messageContent.length() <= 100) {
            messageSent = true;
            drainBattery();
            System.out.println("\nThe message sent to " + firstContact.firstName + " - " + phoneNumber + ", has a length of " + messageContent.length() + ". The battery life has decreased to: " + batteryLife + " hours.");
        } else {
            System.out.println("\nThe message exceeds the maximum number of characters.");
        }

        if(message1.messageContent == null){
            message1 = message;
        } else if (message2.messageContent == null){
            message2 = message;
        }
        messageSent = false;

    }
    @Override
    public void getFirstMessage(String phoneNumber) {
        if(Objects.equals(lastContact.phoneNumber, phoneNumber)) {
            System.out.println(message1.messageContent);
        }
    }

    @Override
    public void getSecondMessage(String phoneNumber) {
        if(Objects.equals(lastContact.phoneNumber, phoneNumber)) {
            System.out.println(message2.messageContent);
        }
    }

    @Override
    public void call(String phoneNumber) {
        if(Objects.equals(lastContact.phoneNumber, phoneNumber)){
            System.out.println("\nCalling " + lastContact.firstName + "...");
            callMade = true;
            drainBattery();
            callHistory = callHistory + lastContact.firstName + " " + lastContact.lastName + " on " + LocalDate.now() + "\n";
        } else if(Objects.equals(firstContact.phoneNumber, phoneNumber)){
            System.out.println("\nCalling " + firstContact.firstName + "...");
            callMade = true;
            drainBattery();
            callHistory = callHistory + firstContact.firstName + " " + firstContact.lastName + " on " + LocalDate.now() + "\n";
        } else {
            System.out.println("Invalid phone number");
        }
        System.out.println("Battery life is: " + batteryLife);
        callMade = false;
    }

    @Override
    public void viewHistory() {
        System.out.println(callHistory);
    }

    void drainBattery() {
        if(messageSent) {
            batteryLife -= 1;
        } else if(callMade) {
            batteryLife -= 2;
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
