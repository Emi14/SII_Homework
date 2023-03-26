package org.siit.homework.week4.first;


import org.siit.homework.week4.first.enums.Material;

import java.awt.*;

public class Week4Main {
    public static void main(String[] args) {

//        API();

        //Metodele de mai jos fac toate cam acelasi lucru dar pentru instante ale diferitelor clase
        //Am respectat tasks pentru fiecare model de telefon in parte
        SamsungGalaxyS6();
        SamsungGalaxyA27();
        AppleIphoneSE();
        AppleIphone14Pro();


    }

    private static void AppleIphone14Pro() {
        Phone phone = new AppleIphone14Pro("698798564");
        ((AppleIphone14Pro) phone).setColor(Color.ORANGE);
        ((AppleIphone14Pro) phone).setMaterial(Material.METAL);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0714683646", "Stefan", "CelMare");
        phone.addContact(2, "0757684929", "Mihai", "Viteazu");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0714683646", "Hi!");
        phone.sendMessage("0714683646", "What are you doing?");
        phone.getFirstMessage("0714683646");
        phone.getSecondMessage("0714683646");

        phone.call("0757684929");
        phone.call("0714683646");
        phone.call("0757684929");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((AppleIphone14Pro) phone).getBatteryLife() + " hours.");
    }

    private static void AppleIphoneSE() {
        Phone phone = new AppleIphoneSE("5694258485");
        ((AppleIphoneSE) phone).setColor(Color.CYAN);
        ((AppleIphoneSE) phone).setMaterial(Material.PLASTIC);
        System.out.println(phone.toString() + "\n");

        phone.addContact(1, "0714683646", "Mihai", "Georgescu");
        phone.addContact(2, "0757684929", "Mircea", "CelBatran");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0714683646", "Hi!");
        phone.sendMessage("0714683646", "What are you doing?");
        phone.getFirstMessage("0714683646");
        phone.getSecondMessage("0714683646");

        phone.call("0757684929");
        phone.call("0714683646");
        phone.call("0757684929");
        phone.viewHistory();

        System.out.println("Battery life is: " + ((AppleIphoneSE) phone).getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyA27() {
        Phone phone = new SamsungGalaxyA33("6542189576");
        ((SamsungGalaxyA33) phone).setColor(Color.BLACK);
        ((SamsungGalaxyA33) phone).setMaterial(Material.GLASS);
        System.out.println(phone.toString() + "\n");

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

        System.out.println("Battery life is: " + ((SamsungGalaxyA33) phone).getBatteryLife() + " hours.");
    }

    private static void SamsungGalaxyS6() {
        Phone phone = new SamsungGalaxyS23("71475689");
        ((SamsungGalaxyS23) phone).setColor(Color.WHITE);
        ((SamsungGalaxyS23) phone).setMaterial(Material.ALUMINUM);
        System.out.println(phone.toString() + "\n");

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

        System.out.println("Battery life is: " + ((SamsungGalaxyS23) phone).getBatteryLife() + " hours.");

    }

    private static void API() {
        Phone phone = new SamsungGalaxyS23("123456789");

        phone.addContact(1, "0745454545", "Andrei", "Popescu");
        phone.addContact(2, "0723232323", "Raul", "Ionescu");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("0745454545", "Hi!");
        phone.sendMessage("0745454545", "How are you?");

        phone.getFirstMessage("0745454545");
        phone.getSecondMessage("0745454545");

        phone.call("0723232323");
        phone.viewHistory();
    }
}
