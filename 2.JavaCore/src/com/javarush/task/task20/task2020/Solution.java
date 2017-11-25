package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
        Sex sex;
        transient PrintStream  outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Person person = new Person("Dima","Karneyenka","Minsk", Sex.MALE);
//        File myFile = File.createTempFile("myFile",null);
//        FileOutputStream outputStream = new FileOutputStream(myFile);
//        ObjectOutputStream out = new ObjectOutputStream(outputStream);
//        out.writeObject(person);
//        out.close();
//
//        FileInputStream inputStream = new FileInputStream(myFile);
//        ObjectInputStream in = new ObjectInputStream(inputStream);
//        Person person1 = (Person)in.readObject();
//        in.close();
//        System.out.println(person.firstName+" "+person.lastName+" "+person.country+" "+person.sex);
//        System.out.println(person1.firstName+" "+person1.lastName+" "+person1.country+" "+person1.sex);

    }
}
