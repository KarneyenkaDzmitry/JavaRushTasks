package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length==3) {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            long textLength = args[2].getBytes().length;
            long position = Long.parseLong(args[1]);
            long fileLength = raf.length();
            if (position < fileLength - textLength) {
                raf.seek(position);
                byte[] buff = new byte[(int) textLength];
                raf.read(buff, 0, (int) textLength);
                raf.seek(fileLength);
                System.out.println(buff.toString()+" - "+new String(buff));
                String text = (new String(buff)).equals(args[2])? "true":"false";
                raf.write(text.getBytes());
                raf.close();
            }
        }
    }
}
