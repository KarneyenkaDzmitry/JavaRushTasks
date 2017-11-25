package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file=null;
        String line="";//D:\Java\Work\Task2207\Task2207.txt
        BufferedReader readerFile = null;
        try {
            file = reader.readLine();
            readerFile = new BufferedReader(new FileReader(file));
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        if (readerFile!=null){
            try {
                    while(readerFile.ready()) {
                        line+= readerFile.readLine()+" ";
                    }
                    line=line.trim();
                //System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        if (line!=null) {
            String words[] = line.split("\\s+");
            for (int i = 0; i <words.length ; i++) {
                String wordMain = words[i];
                if (!(wordMain.equals("del"))){
                    for (int j = i+1; j <words.length; j++) {
                        StringBuilder stringBuilder = new StringBuilder(words[j]);
                        stringBuilder=stringBuilder.reverse();
                        if (wordMain.equals(stringBuilder.toString())){
                            Pair pair = new Pair();
                            pair.first=wordMain;
                            pair.second = words[j];
                            result.add(pair);
                            words[i]="del"; words[j]="del";

                            break;
                        }
                    }
                }
            }
        }
        for (Pair p:result) {
            System.out.println(p.first+" "+p.second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
