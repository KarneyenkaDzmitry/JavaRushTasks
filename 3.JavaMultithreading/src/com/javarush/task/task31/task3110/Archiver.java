package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Дмитрий on 21.11.2017.
 */
public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path="";
        String pathZip="";
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        try {
            pathZip=reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        zipFileManager.createZip(Paths.get(pathZip));
        Command exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
