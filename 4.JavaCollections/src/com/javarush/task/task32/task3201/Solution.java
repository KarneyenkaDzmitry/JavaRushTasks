package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException {
        if (args.length==3){
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            long textLength = args[2].getBytes().length;
            long position = Long.parseLong(args[1]);
            long fileLength = raf.length();
            position = fileLength > position ? position:fileLength;
            raf.seek(position);
            raf.write(args[2].getBytes());
            raf.close();
        }
    }
}
