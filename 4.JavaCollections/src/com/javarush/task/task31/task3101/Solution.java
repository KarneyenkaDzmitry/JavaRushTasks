package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> listNamesOfFiles = new ArrayList<>();

    private static List<File> FileRusult(File file){
        List<File> list = new ArrayList<File>();
        if (file.isDirectory()){
            for (File file2:file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.length() > 50) {
                        FileUtils.deleteFile(file2);
                    } else {
                        list.add(file2);
                    }
                }else {
                    list.addAll(FileRusult(file2));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        if (args.length>0) {
            File path = new File(args[0]);
            File resultFileAbsolutePath = new File(args[1]);
            listNamesOfFiles = FileRusult(path);
            Collections.sort(listNamesOfFiles);
            File allFilesContent = new File(resultFileAbsolutePath.getParent().toString()+"/allFilesContent.txt");
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent);
                for (File name : listNamesOfFiles) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(name);
                        byte[] buff = new byte[fileInputStream.available()];
                        fileInputStream.read(buff);
                        fileOutputStream.write(buff);
                        fileOutputStream.write("\n".getBytes());
                        fileInputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
