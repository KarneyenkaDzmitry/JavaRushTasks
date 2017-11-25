package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName= fileName;
    }



    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);


    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution;
        solution = new Solution("your.file.name");
        solution.writeObject("your.file.name");
        File file = File.createTempFile("your_file_name", null);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(solution);
        out.close();
        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        Solution solution1 = (Solution) in.readObject();

    }
}
