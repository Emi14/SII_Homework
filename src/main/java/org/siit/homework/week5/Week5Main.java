package org.siit.homework.week5;


import org.siit.homework.week5.comparators.ComparatorByName;
import org.siit.homework.week5.person.*;

import java.util.*;

public class Week5Main {
    public static void main(String[] args) {

        //Creating persons
        Person firstPerson = new Unemployed("Felix", 25);
        Person secondPerson = new Student("Marian", 42, "UTCN");
        Person thirdPerson = new Hired("Florin", 30, 3800);

        //Creating treeSet
        Set<Person> personSet = new TreeSet<>(new ComparatorByName()); //We can use .thenComparing for 2nd comparator
        personSet.add(firstPerson);
        personSet.add(secondPerson);
        personSet.add(thirdPerson);
        for (Person person : personSet) {
            System.out.println(person.getName() + ", " + person.getAge());
        }

        //Creating hobbies and adding them to the firstPerson
        Hobby tennis = new Hobby("Tennis", 6);
        tennis.addAddress(new Addresses("Scolarilor", 6, "Bucuresti", "Romania"));
        Hobby football = new Hobby("Football", 4);
        football.addAddress(new Addresses("Fournier", 15, "London", "England"));
        firstPerson.addHobby(tennis);
        firstPerson.addHobby(football);

        //Creating hobbies and adding them to the secondPerson
        football = new Hobby("Football", 2);
        football.addAddress(new Addresses("Carrer de la Pau", 165, "Valencia", "Spain"));
        football.addAddress(new Addresses("Rue de la Victoire", 9, "Lyon", "France"));
        secondPerson.addHobby(football);

        //Creating hobbies and adding them to the secondPerson
        Hobby videoGames = new Hobby("Video Gaming", 7);
        videoGames.addAddress(new Addresses("Bocca di Leone", 8, "Rome", "Italy"));
        Hobby rugby = new Hobby("Rugby", 7);
        rugby.addAddress(new Addresses("OConnel", 20, "Dublin", "Ireland"));
        thirdPerson.addHobby(videoGames);
        thirdPerson.addHobby(rugby);

        //Creating hashMap
        Map<Person, List<Hobby>> personMap = new HashMap<>();
        personMap.put(firstPerson, firstPerson.returnHobby());
        personMap.put(secondPerson, secondPerson.returnHobby());
        personMap.put(thirdPerson, thirdPerson.returnHobby());

        System.out.println(firstPerson + " has the next hobbies " + personMap.get(firstPerson));

    }
}
