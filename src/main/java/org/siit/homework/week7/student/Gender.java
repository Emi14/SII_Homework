package org.siit.homework.week7.student;

public enum Gender
{
    MALE,FEMALE,Male,Female,male,female,m,f,M,F;

    public String toString(){
        switch(this){
            case MALE:
                return "MALE";
            case FEMALE:
                return "FEMALE";
            case Male:
                return "Male";
            case Female:
                return "Female";
            case male:
                return "male";
            case female:
                return "female";
            case m:
                return "m";
            case f:
                return "f";
            case M:
                return "M";
            case F:
                return "F";
        }
        return null;
    }
}
