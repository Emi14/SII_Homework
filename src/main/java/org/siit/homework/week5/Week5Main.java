package org.siit.homework.week5;


import org.siit.homework.week5.comparators.ComparatorByName;
import org.siit.homework.week5.person.*;

import java.util.*;

public class Week5Main {
    public static void main(String[] args) {

        //Creating persons
        Person firstPerson = new Unemployed("Alex", 33);
        Person secondPerson = new Student("Vlad", 22, "Politehnica");
        Person thirdPerson = new Hired("Ionut", 45, 4500);

        //Creating treeSet
        Set<Person> personSet = new TreeSet<>(new ComparatorByName()); //We can use .thenComparing for 2nd comparator
        personSet.add(firstPerson);
        personSet.add(secondPerson);
        personSet.add(thirdPerson);
        for (Person person : personSet) {
            System.out.println(person.getName() + ", " + person.getAge());
        }

        //Creating hobbies and adding them to the firstPerson
        Hobby tennis = new Hobby("Squash", 2);
        tennis.addAddress(new Addresses("Oltenitei", 207, "Bucuresti", "Romania"));
        Hobby football = new Hobby("Football", 3);
        football.addAddress(new Addresses("Principala", 56, "Slobozia", "Romania"));
        firstPerson.addHobby(tennis);
        firstPerson.addHobby(football);

        //Creating hobbies and adding them to the secondPerson
        Hobby darts = new Hobby("Swim", 3);
        darts.addAddress(new Addresses("Bucuresti", 93, "Ploiesti", "Romania"));
        darts.addAddress(new Addresses("Grivita", 33, "Bucuresti", "Romania"));
        secondPerson.addHobby(darts);

        //Creating hobbies and adding them to the secondPerson
        Hobby videoGames = new Hobby("Running", 4);
        videoGames.addAddress(new Addresses("Ghencea", 78, "Bucuresti", "Romania"));
        Hobby rugby = new Hobby("Chess", 3);
        rugby.addAddress(new Addresses("Unirii", 78, "Bucuresti", "Romania"));
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
