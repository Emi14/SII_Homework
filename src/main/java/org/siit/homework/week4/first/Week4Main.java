package org.siit.homework.week4.first;


import org.siit.homework.week4.first.enums.Material;

import java.awt.*;

public class Week4Main {
    public static void main(String[] args) {

//        API();

        //Metodele de mai jos fac toate cam acelasi lucru dar pentru instante ale diferitelor clase
        //Am respectat tasks pentru fiecare model de telefon in parte
        SamsungGalaxyS6();
        SamsungGalaxyA20E();
        AppleIphoneXS();
        AppleIphone7Plus();


    }

    public static void AppleIphone7Plus() {
        AppleIphoneXS phone = new AppleIphoneXS("647853578");
        phone.setColor(Color.PINK);
        phone.setMaterial(Material.METAL);
        System.out.println(phone + "\n");

        phone.addContact(1, "0736447558", "Muresan", "Mihai");
        phone.addContact(2, "0721452388", "Firica", "Denisa");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0736447558", "Hi!");
        phone.sendMessage("0734667558", "What are you doing?");
        phone.getFirstMessage("0736447558");
        phone.getSecondMessage("0736447558");

        phone.call("0721452388");
        phone.call("0736447558");
        phone.call("0721452388");
        phone.viewHistory();

        System.out.println("Battery life is: " + phone.getBatteryLife() + " hours.");
    }

    private static void AppleIphoneXS() {
        AppleIphone7Plus phone = new AppleIphone7Plus("489427589");
        phone.setColor(Color.YELLOW);
        phone.setMaterial(Material.PLASTIC);
        System.out.println(phone + "\n");

        phone.addContact(1, "0754864812", "Popescu", "Sorin");
        phone.addContact(2, "0724575197", "Motorga", "Catalin");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0754864812", "Hi!");
        phone.sendMessage("0754864812", "What are you doing?");
        phone.getFirstMessage("0754864812");
        phone.getSecondMessage("0754864812");

        phone.call("0754864812");
        phone.call("0724575197");
        phone.call("0754864812");
        phone.viewHistory();

        System.out.println("Battery life is: " + phone.getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyA20E() {
        SamsungGalaxyA20E phone = new SamsungGalaxyA20E("548154872");
        phone.setColor(Color.BLACK);
        phone.setMaterial(Material.PLASTIC);
        System.out.println(phone + "\n");

        phone.addContact(1, "0748965742", "Popa", "Vali");
        phone.addContact(2, "0757684929", "Toma", "Andrei");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0748965742", "Hi!");
        phone.sendMessage("0748965742", "What are you doing?");
        phone.getFirstMessage("0748965742");
        phone.getSecondMessage("0748965742");

        phone.call("0757684929");
        phone.call("0748965742");
        phone.call("0757684929");
        phone.viewHistory();

        System.out.println("Battery life is: " + phone.getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyS6() {
        SamsungGalaxyS6 phone = new SamsungGalaxyS6("71475689");
        phone.setColor(Color.WHITE);
        phone.setMaterial(Material.ALUMINUM);
        System.out.println(phone + "\n");

        phone.addContact(1, "0714683646", "Popescu", "Alin");
        phone.addContact(2, "0757684929", "Alexandrescu", "Ionut");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0714683646", "Hi!");
        phone.sendMessage("0714683646", "What are you doing?");
        phone.getFirstMessage("0714683646");
        phone.getSecondMessage("0714683646");

        phone.call("0757684929");
        phone.viewHistory();

        System.out.println("Battery life is: " + phone.getBatteryLife() + " hours.");

    }


}
