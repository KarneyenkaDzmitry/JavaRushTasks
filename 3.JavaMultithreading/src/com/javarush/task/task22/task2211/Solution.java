package com.javarush.task.task22.task2211;

import java.io.*;
import java.util.Collections;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        if (args.length>0){
            FileInputStream fileInputStream= new FileInputStream(args[0]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

                byte buff[] = new byte[fileInputStream.available()];
                fileInputStream.read(buff);

                String line = new String(buff,"UTF-8");
            //System.out.println(line);
                buff=line.getBytes("Windows-1251");

                fileOutputStream.write(buff);

            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
