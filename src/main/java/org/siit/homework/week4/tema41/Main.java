package org.siit.homework.week4.tema41;


import org.siit.homework.week4.tema41.lg.L3;
import org.siit.homework.week4.tema41.samsung.GalaxyS6;
import org.siit.homework.week4.tema41.samsung.GalaxyS7;

public class Main {

    //    Create an application which will monitor the phone activity - send messages, receive calls, monitor the battery etc.

    public static void main(String[] args) {
        String phoneNumber1 = "123456";
        String phoneNumber2 = "123457";
        System.out.println("-------------------------------------------------------------------" +
                "\n ->Phone 1 Details" +
                "\n...................................................................");
        Phone phone1 = new GalaxyS6();
        phone1.setColor("Red");
        phone1.setMaterial("Aluminum");
        System.out.println(phone1);
        System.out.println("\n------------------------- Phone 1 Contacts ------------------------");
        phone1.addContact("1", phoneNumber1, "Ion","Popescu");
        phone1.addContact("2", phoneNumber2, "Vasile","Munteanu");
        System.out.println("First Contact: " + phone1.getFirstContact());
        System.out.println("Last Contact: " + phone1.getLastContact());
        System.out.println("\n------------------------- Phone 1 Messages ------------------------");
        phone1.sendMessage(phoneNumber1,"Hello");
        phone1.sendMessage(phoneNumber1,"Ciao");
        phone1.sendMessage(phoneNumber2,"Hi");
        System.out.println(phone1.getFirstMessage(phoneNumber1));
        System.out.println(phone1.getSecondMessage(phoneNumber1));
        System.out.println(phone1.getFirstMessage(phoneNumber2));
        System.out.println(phone1);
        System.out.println("\n-------------------------- Phone 1 Calls --------------------------");
        phone1.call(phoneNumber1);
        phone1.call(phoneNumber2);
        phone1.call("123459");
        phone1.viewHistory();
        System.out.println(phone1);

        System.out.println("-------------------------------------------------------------------" +
                "\n ->Phone 2 Details" +
                "\n...................................................................");
        Phone phone2 = new L3();
        System.out.println(phone2);

        System.out.println("-------------------------------------------------------------------" +
                "\n ->Phone 3 Details" +
                "\n...................................................................");
        Phone phone3 = new GalaxyS7();
        System.out.println(phone3);
    }
}