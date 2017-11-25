package com.javarush.task.task20.task2019;

import sun.awt.image.OffScreenImageSource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
        //System.out.println(loadedObject.getMap().get("mouse"));

    }
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        m = (Map<String, String>) in.readObject();
//    }
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        out.writeObject(getMap());
//    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
