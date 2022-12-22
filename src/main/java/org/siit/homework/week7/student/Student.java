package org.siit.homework.week7.student;

import java.util.Objects;

public class Student {
        private String firstName;
        private String lastName;
        private String dateOfBirth;
        private String gender;
        private final String id;
        private int age;

        public Student(String firstName, String lastName, String dateOfBirth, String gender, String id) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.dateOfBirth = dateOfBirth;
                this.gender = gender;
                this.id = id;
        }



        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public String getDateOfBirth() {
                return dateOfBirth;
        }

        public String getGender() {
                return gender;
        }

        public String getId() {
                return id;
        }

        @Override
        public String toString() {
                return "Student{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", dateOfBirth='" + dateOfBirth + '\'' +
                        ", gender='" + gender + '\'' +
                        ", id='" + id + '\'' +
                        ", age=" + age +
                        '}'+"\n";
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(gender, student.gender) && Objects.equals(id, student.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(firstName, lastName, dateOfBirth, gender, id, age);
        }
}
