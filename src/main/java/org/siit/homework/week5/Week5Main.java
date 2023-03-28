package org.siit.homework.week5;


import org.siit.homework.week5.comparators.ComparatorByName;
import org.siit.homework.week5.person.*;

import java.util.*;

public class Week5Main {
    public static void main(String[] args) {

        //Creating persons
        Person firstPerson = new Unemployed("Felix", 25);
        Person secondPerson = new Student("Radu", 18, "UTCN");
        Person thirdPerson = new Hired("Florin", 32, 3500);

        //Creating treeSet
        Set<Person> personSet = new TreeSet<>(new ComparatorByName()); //We can use .thenComparing for 2nd comparator
        personSet.add(firstPerson);
        personSet.add(secondPerson);
        personSet.add(thirdPerson);
        for (Person person : personSet) {
            System.out.println(person.getName() + ", " + person.getAge());
        }

        //Creating hobbies and adding them to the firstPerson
        Hobby tennis = new Hobby("Tennis", 3);
        tennis.addAddress(new Addresses("Republicii", 15, "Turda", "Romania"));
        Hobby football = new Hobby("Football", 3);
        football.addAddress(new Addresses("Sunny", 38, "London", "England"));
        firstPerson.addHobby(tennis);
        firstPerson.addHobby(football);

        //Creating hobbies and adding them to the secondPerson
        Hobby darts = new Hobby("Darts", 2);
        darts.addAddress(new Addresses("Independencia", 104, "Madrid", "Spain"));
        darts.addAddress(new Addresses("Republique", 51, "Toulouse", "France"));
        secondPerson.addHobby(darts);

        //Creating hobbies and adding them to the secondPerson
        Hobby videoGames = new Hobby("Video Gaming", 5);
        videoGames.addAddress(new Addresses("Liberta", 4, "Rome", "Italy"));
        Hobby rugby = new Hobby("Rugby", 2);
        rugby.addAddress(new Addresses("4th Avenue", 87, "Dublin", "Ireland"));
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
