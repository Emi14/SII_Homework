package org.siit.homework.week5;
import java.util.*;

public class Main {

//    - you need to store Person in a TreeSet
//    - define 2 Comparators (one for name and one for age) that will be used when creating the TreeSet
//    - add Person to the TreeSet
//    - iterate through the TreeSet and print the name and the age
//    - you need to store some information about people: for one person, you need a list of his/her hobbies
//    - define for Hobby a class that contains
//            name of the hobby (String) – ex: cycling, swimming
//            frequency (int) – how many times a week they practice it
//            list of addresses where this hobby can be practiced (List<Address>)
//    - you will use a HashMap with the following structure <Person, List<Hobby>>
//    - add some information to this map - any detail you consider relevant
//    - for a certain Person, print the names of the hobbies and the countries where it can be practiced
//    - use some example classes, appropriately, such as: Person, Unemployed, Hired, Student, Address, Country

    public static void main(String[] args) {
        Set<Person> treeSet = new TreeSet<>(new PersonComparatorByName().thenComparing(new PersonComparatorByAge()));
        Map<Person, List<Hobby>> personsByHobby = new HashMap<>();

        // person 1
        Person person = new Person("Ion", 23);
        treeSet.add(person);
        List<Hobby> hobbyList = new ArrayList<>();
        hobbyList.add(new Hobby("cycling",4, new ArrayList<>(Arrays.asList("Spain", "Germany"))));
        hobbyList.add(new Hobby("swimming",2, new ArrayList<>(Arrays.asList("Romania"))));
        hobbyList.add(new Hobby("tennis",1, new ArrayList<>(Arrays.asList("Italy", "Germany"))));
        personsByHobby.put(person, hobbyList);

        // person 2
        person = new Person("Vasile", 27);
        treeSet.add(person);
        hobbyList = new ArrayList<>();
        hobbyList.add(new Hobby("fitness",2, new ArrayList<>(Arrays.asList("France"))));
        hobbyList.add(new Hobby("jogging",3, new ArrayList<>(Arrays.asList("Poland", "Germany"))));
        hobbyList.add(new Hobby("cycling",3, new ArrayList<>(Arrays.asList("Croatia"))));
        personsByHobby.put(person, hobbyList);

        System.out.println("------- People in the list -----------");
        for (Person p : treeSet) {
            System.out.println("Name: " + p.getName() + " - Age: " + p.getAge());
        }

        // print hobbies for first person in the treeset
        Person firstPerson = treeSet.iterator().next();
        System.out.println("\n--------- First person in the set is " + firstPerson.getName() + ", aged " + firstPerson.getAge() + " ----------");
        System.out.println("\tList of hobbies = " + personsByHobby.get(firstPerson));
    }
}
