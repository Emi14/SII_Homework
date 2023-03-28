package org.siit.homework.week5.person;

import java.util.List;

public interface Person {

    String getName();
    int getAge();
    void addHobby(Hobby hobby);
    List<Hobby> returnHobby();

}
