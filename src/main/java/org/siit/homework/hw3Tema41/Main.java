package org.siit.homework.hw3Tema41;
import org.siit.homework.hw3Tema41.onePlus.OnePlus7Pro;
import org.siit.homework.hw3Tema41.onePlus.OnePlusNord;
import org.siit.homework.hw3Tema41.samsung.GalaxyS10;
import org.siit.homework.hw3Tema41.samsung.GalaxyS6;

public class Main {
    public static void main(String[] args) {

        String phoneNumber1 = "+40702067779";
        String phoneNumber2 = "+40702065948";

        System.out.println("Phone 1: ");
        Phone phone1 = new GalaxyS6();
        phone1.setColor("Gold");
        phone1.setMaterial("Glass");
        System.out.println(phone1);
        System.out.println("...");
        System.out.println("Phone 1 Contacts: ");
        phone1.addContact("1", phoneNumber1, "Gabriela", "Dimitrescu");
        phone1.addContact("2", phoneNumber2, "Horia", "Sava");
        System.out.println("Contact 1: " + phone1.getFirstContact());
        System.out.println("Contact 2: " + phone1.getLastContact());
        System.out.println("...");
        System.out.println("Phone 1. Send Messages: ");
        phone1.sendMessage(phoneNumber1, "Hello!");
        phone1.sendMessage(phoneNumber1, "Servus!");
        System.out.println(phone1.getFirstMessage(phoneNumber1));
        System.out.println(phone1.getSecondMessage(phoneNumber1));
        System.out.println("...");
        System.out.println("Phone 1. Calling: ");
        phone1.call(phoneNumber2);
        System.out.println("...");
        phone1.viewHistory();
        System.out.println("Check your battery life: " + phone1);

        System.out.println("..................................." +
                "\nPhone 2: ");
        Phone phone2 = new GalaxyS10();
        System.out.println(phone2);
        System.out.println("...");
        System.out.println("Phone 2 Contacts: ");
        phone2.addContact("1", phoneNumber1, "Gabriela", "Dimitrescu");
        phone2.addContact("2", phoneNumber2, "Horia", "Sava");
        System.out.println("Contact 1: " + phone2.getFirstContact());
        System.out.println("Contact 2: " + phone2.getLastContact());
        System.out.println("...");
        System.out.println("Phone 2. Send Messages: ");
        phone2.sendMessage(phoneNumber1, "Hello!");
        phone2.sendMessage(phoneNumber1, "Servus!");
        System.out.println(phone2.getFirstMessage(phoneNumber1));
        System.out.println(phone2.getSecondMessage(phoneNumber1));
        System.out.println("...");
        System.out.println("Phone 2. Calling: ");
        phone2.call(phoneNumber1);
        phone2.call(phoneNumber2);
        System.out.println("...");
        phone2.viewHistory();
        System.out.println("Check your battery life: " + phone2);

        System.out.println("..................................." +
                "\nPhone 3: ");
        Phone phone3 = new OnePlus7Pro();
        System.out.println(phone3);

        System.out.println("..................................." +
                "\nPhone 4: ");
        Phone phone4 = new OnePlusNord();
        System.out.println(phone4);

    }
}
