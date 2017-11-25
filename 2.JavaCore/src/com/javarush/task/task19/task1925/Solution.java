package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
    if (args.length>0){
        String resultLine = new String();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while(reader.ready())
        {
            String line = reader.readLine();
            line = line.replaceAll("(?<=\\s|^)\\S{1,6}(?=\\s|$)", "");
            resultLine=resultLine+line;
        }
        reader.close();
        resultLine = resultLine.replaceAll("\\s+"," ");
        resultLine=resultLine.trim();
        resultLine = resultLine.replaceAll("\\s",",");

        FileWriter fileWriter = new FileWriter(args[1]);
        fileWriter.write(resultLine);
        fileWriter.close();

    }
    }
}
