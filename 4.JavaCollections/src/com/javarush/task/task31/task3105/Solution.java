package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path fileAdd = Paths.get(args[0]);
        String nameFile = fileAdd.getFileName().toString();
        //System.out.println(nameFile);
        Path FileZip = Paths.get(args[1]);
        Path fileAddNew = Paths.get("new\\"+fileAdd.getFileName());
        //System.out.println(fileAddNew);
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile))){
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(FileZip))){
                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry!=null){
                    if (!zipEntry.getName().equals(nameFile)){
                        zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName().toString()));
                        byte[] buffer = new byte[8 * 1024];
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            zipOutputStream.write(buffer, 0, len);
                        }
                        zipOutputStream.closeEntry();
                        zipInputStream.closeEntry();
                    }

                    zipEntry = zipInputStream.getNextEntry();
                }
            }

                zipOutputStream.putNextEntry(new ZipEntry(fileAdd.toString()));
        }

    }
}
