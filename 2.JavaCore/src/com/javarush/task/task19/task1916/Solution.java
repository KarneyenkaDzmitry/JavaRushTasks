package com.javarush.task.task19.task1916;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
while (list1.size() > 0 && list2.size() > 0) {
 if (list1.get(0).equals(list2.get(0))) {
 lines.add(new LineItem(Type.SAME, list1.get(0)));
  list1.remove(0);
  list2.remove(0);
   } else if (list1.get(0).equals(list2.get(1))) {
    lines.add(new LineItem(Type.ADDED, list2.get(0)));
     list2.remove(0);
     }
      else { lines.add(new LineItem(Type.REMOVED, list1.get(0)));
       list1.remove(0);
       }
       }
       if (list1.size() == 1) {
       lines.add(new LineItem(Type.REMOVED, list1.get(0)));
        list1.remove(0);
         } else if (list2.size() == 1) {
          lines.add(new LineItem(Type.ADDED, list2.get(0)));
           list2.remove(0); }
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException,FileNotFoundException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String file1 = reader.readLine();//D:\Java\Work\Task1928\file1.txt
    String file2 = reader.readLine();
    reader.close();
    ArrayList<String> listFile1 = new ArrayList<String>();
    ArrayList<String> listFile2 = new ArrayList<String>();
    BufferedReader readerFile1 = new BufferedReader(new FileReader(file1));
    BufferedReader readerFile2 = new BufferedReader(new FileReader(file2));
    while (readerFile1.ready()){
        String line = readerFile1.readLine();
        listFile1.add(line);
    }
    while (readerFile2.ready()){
            String line = readerFile2.readLine();
            listFile2.add(line);
    }
    readerFile1.close();
    readerFile2.close();
    if (listFile1.size()>listFile2.size()) {
        for (int i = 0; i < listFile1.size()-1; i++) {

            if (listFile1.get(i).equals(listFile2.get(i))) {
                lines.add(new LineItem(Type.SAME, listFile1.get(i)));
            } else {
                if (listFile1.get(i).equals(listFile2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, listFile2.get(i)));
                    listFile1.add(i, "");
                } else {
                    lines.add(new LineItem(Type.REMOVED, listFile1.get(i)));
                    listFile2.add(i, "");
                }
            }

        }
    }else {
        for (int i = 0; i < listFile2.size()-1; i++) {

            if (listFile1.get(i).equals(listFile2.get(i))) {
                lines.add(new LineItem(Type.SAME, listFile1.get(i)));
            } else {
                if (listFile1.get(i).equals(listFile2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, listFile2.get(i)));
                    listFile1.add(i, "");
                } else {
                    lines.add(new LineItem(Type.REMOVED, listFile1.get(i)));
                    listFile2.add(i, "");
                }
            }

        }

    }
        if (listFile1.size()>listFile2.size())
            lines.add(new LineItem(Type.REMOVED, listFile1.get(listFile1.size()-1)));
        else {lines.add(new LineItem(Type.ADDED, listFile2.get(listFile2.size()-1)));}

        for (LineItem ignored : lines) System.out.println(ignored.type +" "+ ignored.line);

    }





    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
