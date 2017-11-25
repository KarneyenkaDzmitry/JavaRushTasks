package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> listResults = new ArrayList<String>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(root);
        while(true) {
            try {
                String nameFile = queue.poll();
                if (nameFile!=null) {
                    File files = new File(nameFile);
                    for (File name : files.listFiles()) {
                        if (name.isDirectory()) {
                            queue.add(name.getAbsolutePath());
                        } else {
                            listResults.add(name.getAbsolutePath());
                        }
                    }
                }else{break;}

            } catch (NoSuchElementException e) {
                break;
            }
        }
        return listResults;

    }

    public static void main(String[] args) {
        /*if (args.length>0) {
            String path = args[0];
            List<String> listNamesOfFiles = null;
            try {
                listNamesOfFiles = getFileTree(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Collections.sort(listNamesOfFiles);
            for (String nameFile : listNamesOfFiles) {
                System.out.println(nameFile);

            }
        }*/
    }
}
