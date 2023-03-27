package org.siit.homework.week4.first;


import org.siit.homework.week4.first.enums.Material;

import java.awt.*;

public class Week4Main {
    public static void main(String[] args) {

        SamsungGalaxyS4();
        SamsungGalaxyA2018();
        AppleIphone6Plus();
        AppleIphone5S();
    }

    private static void AppleIphone5S() {
        Phone phone = new AppleIphone5S("389626504");
        ((AppleIphone5S) phone).setColor(Color.GRAY);
        ((AppleIphone5S) phone).setMaterial(Material.METAL);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0723569894", "Vasile", "Popescu");
        phone.addContact(2, "0744659563", "Mihai", "Grigoroiu");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0723569894", "Salut!");
        phone.sendMessage("0723569894", "La ce ora ne vedem maine?");
        phone.getFirstMessage("0723569894");
        phone.getSecondMessage("0723569894");

        phone.call("0744659563");
        phone.call("0723569894");
        phone.call("0744659563");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((AppleIphone5S) phone).getBatteryLife() + " hours.");
    }

    private static void AppleIphone6Plus() {
        Phone phone = new AppleIphone6Plus("3862134243");
        ((AppleIphone6Plus) phone).setColor(Color.RED);
        ((AppleIphone6Plus) phone).setMaterial(Material.METAL);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0744235689", "Marian", "Arpasanu");
        phone.addContact(2, "0723784512", "Doina", "Ionescu");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0744235689", "Buna!");
        phone.sendMessage("0744235689", "Ce mai stii de Alex?");
        phone.getFirstMessage("0744235689");
        phone.getSecondMessage("0744235689");

        phone.call("0723784512");
        phone.call("0744235689");
        phone.call("0723784512");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((AppleIphone6Plus) phone).getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyA2018() {
        Phone phone = new SamsungGalaxyA2018("3321045333");
        ((SamsungGalaxyA2018) phone).setColor(Color.WHITE);
        ((SamsungGalaxyA2018) phone).setMaterial(Material.GLASS);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0723668512", "Andrei", "Dumitru");
        phone.addContact(2, "0744264589", "Ionut", "Anghel");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0723668512", "Salutare!");
        phone.sendMessage("0723668512", "Cum te mai simti?");
        phone.getFirstMessage("0723668512");
        phone.getSecondMessage("0723668512");

        phone.call("0744264589");
        phone.call("0723668512");
        phone.call("0744264589");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((SamsungGalaxyA2018) phone).getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyS4() {
        Phone phone = new SamsungGalaxyS4("30243345");
        ((SamsungGalaxyS4) phone).setColor(Color.GREEN);
        ((SamsungGalaxyS4) phone).setMaterial(Material.PLASTIC);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0757461278", "Paul", "Grigore");
        phone.addContact(2, "0757684929", "Ionut", "Voinea");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0757461278", "Salut!");
        phone.sendMessage("0757461278", "Ce faci?");
        phone.getFirstMessage("0757461278");
        phone.getSecondMessage("0757461278");

        phone.call("0723895623");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((SamsungGalaxyS4) phone).getBatteryLife() + " hours.");

    }

}
