package org.siit.projects.phoneApp;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SamsungGalaxyS6();
        SamsungGalaxyNote();


//        API();

    }

    private static void SamsungGalaxyNote() {
        SamsungGalaxyNote phone = new SamsungGalaxyNote("324345765888");
        phone.setColor(Color.BLUE);
        phone.setMaterial(Material.CARBON);

        phone.addContact("1", "0732323232", "Andreea", "Kline");

        phone.addContact("2", "0845454545", "John", "Snow");

        phone.getFirstContact();

        phone.getLastContact();

        phone.sendMessage("0732323232", "Hello!");
        phone.sendMessage("0732323232", "Please take out the garbage and do the laundry.");
        phone.sendMessage("0732323232", "My mother is coming to visit.");


        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

        phone.call("0845454545");
        phone.call("0732323232");

        phone.viewHistory();

    }
    private static void SamsungGalaxyS6() {

        Samsung phone = new SamsungGalaxyS6("123457875476");
        phone.setColor(Color.DARK_GRAY);
        phone.setMaterial(Material.PLASTIC);
        System.out.println(phone.toString());

        phone.addContact("1", "0732323232", "Monica", "Smith");

        phone.addContact("2", "0845454545", "Mihai", "Costas");

        phone.getFirstContact();

        phone.getLastContact();

        phone.sendMessage("0732323232", "Good morning!");
        phone.sendMessage("0732323232", "We leave at 10:00 in the evening");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

        phone.call("0845454545");
        phone.call("0732323232");

        phone.viewHistory();
    }

    private static void API() {

        Phone phone = new SamsungGalaxyS6("123457875476");

        phone.addContact("1", "0732323232", "Monica", "Smith");

        phone.addContact("2", "0845454545", "Mihai", "Costas");

        phone.getFirstContact();

        phone.getLastContact();

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendMessage("0732323232", "Good morning!");

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone.call("0845454545");
        phone.call("0732323232");

        phone.viewHistory();
    }
}
