package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(file));//D:\Java\Work\Task1925\File1.txt
        while (readerFile.ready()) {
            StringBuilder stringBuilder = new StringBuilder(readerFile.readLine());
            System.out.println(stringBuilder.reverse());
        }
        readerFile.close();
    }
}
