package org.siit.homework.week4.first;


import org.siit.homework.week4.first.enums.Material;

import java.awt.*;
import java.time.LocalDate;

public class AppleIphone5S implements Phone {

    private double batteryLife = 85;
    private Material material;
    private Color color;
    private String IMEI;
    private Contact firstContact;
    private Contact lastContact;
    private String callHistory = "Recent calls:" + "\n";

    public AppleIphone5S(String IMEI) {
        this.IMEI = IMEI;
    }

    /**
     * Adds a contact to the desired place, first or second.
     * @param place
     * @param phoneNumber
     * @param firstName
     * @param lastName
     */
    @Override
    public void addContact(int place, String phoneNumber, String firstName, String lastName) {
        if (place == 1) {
            this.firstContact = new Contact(place, phoneNumber, firstName, lastName);
        } else if (place == 2) {
            this.lastContact = new Contact(place, phoneNumber, firstName, lastName);
        } else {
            System.out.println("Invalid place!");
        }
    }

    /**
     * Prints the first contact.
     */
    @Override
    public void getFirstContact() {
        System.out.println(firstContact.toString());
    }

    /**
     * Prints the second contact
     */
    @Override
    public void getLastContact() {
        System.out.println(lastContact.toString());
    }

    /**
     * Sends a message to the desired contact and stores it in the first or second place.
     * @param phoneNumber
     * @param messageContent
     */
    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (phoneNumber == this.firstContact.phoneNumber) {
            if (this.firstContact.firstMessage == null) {
                this.firstContact.firstMessage = new Message(1, messageContent);
                this.batteryLife -= 1;
            } else if (this.firstContact.lastMessage == null) {
                this.firstContact.lastMessage = new Message(2, messageContent);
                this.batteryLife -= 1;
            } else {
                System.out.println("Out of memory!");
            }
        } else if (phoneNumber == this.lastContact.phoneNumber) {
            if (this.lastContact.firstMessage == null) {
                this.lastContact.firstMessage = new Message(1, messageContent);
            } else if (this.lastContact.lastMessage == null) {
                this.lastContact.lastMessage = new Message(2, messageContent);
            } else {
                System.out.println("Out of memory!");
            }
        }
    }

    /**
     * Prints the first message to a contact.
     * @param phoneNumber
     */
    @Override
    public void getFirstMessage(String phoneNumber) {
        if (firstContact.phoneNumber == phoneNumber) {
            System.out.println(firstContact.firstMessage.getMessageContent());
        } else if (lastContact.phoneNumber == phoneNumber) {
            System.out.println(lastContact.firstMessage.getMessageContent());
        } else {
            System.out.println("Invalid phone number!");
        }
    }

    /**
     * Prints the second message to a contact.
     * @param phoneNumber
     */
    @Override
    public void getSecondMessage(String phoneNumber) {
        if (firstContact.phoneNumber == phoneNumber) {
            System.out.println(firstContact.lastMessage.getMessageContent());
        } else if (lastContact.phoneNumber == phoneNumber) {
            System.out.println(lastContact.lastMessage.getMessageContent());
        } else {
            System.out.println("Invalid phone number!");
        }
    }

    /**
     * Makes a call to a contact and stores the call in recent calls.
     * @param phoneNumber
     */
    @Override
    public void call(String phoneNumber) {
        if (phoneNumber == this.firstContact.phoneNumber) {
            System.out.println("Calling " + this.firstContact.firstName +
                    " " + this.firstContact.lastName);
            this.callHistory = this.callHistory + this.firstContact.firstName +
                    " " + this.firstContact.lastName + " in " + LocalDate.now() + "\n";
            this.batteryLife -= 2;
        } else if (phoneNumber == this.lastContact.phoneNumber) {
            System.out.println("Calling " + this.lastContact.firstName +
                    " " + this.lastContact.lastName);
            this.callHistory = this.callHistory + this.lastContact.firstName +
                    " " + this.lastContact.lastName + " in " + LocalDate.now() + "\n";
            this.batteryLife -= 2;
        } else {
            System.out.println("Invalid phone number!");
        }
    }

    /**
     * Prints the call history.
     */
    @Override
    public void viewHistory() {
        System.out.println(this.callHistory);
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "material=" + material +
                ", color=" + color +
                ", IMEI='" + IMEI + '\'' +
                '}';
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public String getIMEI() {
        return IMEI;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
