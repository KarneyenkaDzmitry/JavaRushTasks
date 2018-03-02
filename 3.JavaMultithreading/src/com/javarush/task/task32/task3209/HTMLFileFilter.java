package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.nio.file.Files;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String nameFile = f.getName().toLowerCase();
        if ((f.isDirectory()) || ((nameFile.endsWith(".html")) || (nameFile.endsWith(".htm")))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
