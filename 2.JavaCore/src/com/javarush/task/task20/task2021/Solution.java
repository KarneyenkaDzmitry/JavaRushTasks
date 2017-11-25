package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }
        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }
//    public class NotSerializableException extends Throwable {
//        public NotSerializableException(){}
//    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SubSolution person = new SubSolution();
//        File myFile = File.createTempFile("myFile",null);
//        FileOutputStream outputStream = new FileOutputStream(myFile);
//        ObjectOutputStream out = new ObjectOutputStream(outputStream);
//        out.writeObject(person);
//        out.close();
//
//        FileInputStream inputStream = new FileInputStream(myFile);
//        ObjectInputStream in = new ObjectInputStream(inputStream);
//        SubSolution person1 = (SubSolution) in.readObject();
//        in.close();
////        System.out.println(person.firstName+" "+person.lastName+" "+person.country+" "+person.sex);
////        System.out.println(person1.firstName+" "+person1.lastName+" "+person1.country+" "+person1.sex);


    }
}
