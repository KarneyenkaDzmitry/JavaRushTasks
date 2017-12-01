package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("D:\\Java\\Work\\Task3101"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        InputStream input  =url.openStream();
        //Path tempFile = Files.createFile(Paths.get("D:\\Java\\Work\\Task3101\\new7.tmp"));
        Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
        String nameFiles[] = urlString.split("\\/");
        String name = nameFiles[nameFiles.length-1];
        Path path = Paths.get(downloadDirectory.toAbsolutePath().toString(), name);
        System.out.println(path);
        Files.move(tempFile, path/*, StandardCopyOption.REPLACE_EXISTING*/);

        /* String fieName=urlString.substring(urlString.lastIndexOf("/"));
        Path destPath=Paths.get(downloadDirectory.toString(), fieName);
Files.move(tmp,destPath);*/
       return path; // implement this method
    }
}
