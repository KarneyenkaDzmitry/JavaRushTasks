package com.javarush.task.task31.task3110;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by Дмитрий on 21.11.2017.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);

            try (InputStream inputStream = Files.newInputStream(source);) {
                while (inputStream.available() > 0) {
                    byte[] buff = new byte[1000];
                    int numberBytes = inputStream.read(buff);
                    zipOutputStream.write(buff, 0, numberBytes);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}
