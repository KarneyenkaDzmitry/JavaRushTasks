package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<Path>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isOk=true;
        String string = new String(Files.readAllBytes(file));
        byte[] content = Files.readAllBytes(file);

        if (isOk&&(partOfName!=null)){
            isOk=file.toString().contains(partOfName);
        }
        if (isOk&&(partOfContent!=null)){
            isOk = string.contains(partOfContent);
        }
        if (isOk&&(minSize>0)){
            if (content.length<minSize){
                isOk=false;// размер файла: content.length
            }
        }
        if (isOk&&(maxSize>0)){
            if (content.length>maxSize){
                isOk=false;
            }
        }
        if (isOk){
            foundFiles.add(file);
        }



        return super.visitFile(file, attrs);
    }
}
