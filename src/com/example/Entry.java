package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.Map;

public class Entry {
    public static void main(String[] args){
        Path path = Path.of(".", "Test.txt");

        createTestFile(path);

        viewAttributes1(path);
        viewAttributes2(path);
        viewAttributes3(path);
        viewAttributes4(path);
        viewAttributes5(path);
    }

    private static void createTestFile(Path path){
        try {
            if (Files.notExists(path))
                Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewAttributes1(Path path) {
        try {
            Files.getLastModifiedTime(path); //1

            Files.isDirectory(path); //2
            Files.isRegularFile(path); //3
            Files.isSymbolicLink(path); //4

            Files.isExecutable(path); //5
            Files.isHidden(path); //6

            Files.isReadable(path); //7
            Files.isWritable(path); //8

            Files.size(path); //9

            Files.getOwner(path); //10
        } catch (IOException e){
            System.out.println(e);
        }
    }

    private static void viewAttributes2(Path path){
        try {
            DosFileAttributes attributes = Files
                    .getFileAttributeView(path, DosFileAttributeView.class)
                    .readAttributes();

            attributes.lastModifiedTime(); //1
            attributes.lastAccessTime(); //2
            attributes.creationTime(); //3

            attributes.isDirectory(); //4
            attributes.isRegularFile(); //5

            attributes.isSymbolicLink(); //6
            attributes.isOther(); //7
            attributes.fileKey(); //8

            attributes.size(); //9

            attributes.isHidden(); //10
            attributes.isSystem(); //11
            attributes.isArchive(); //12
            attributes.isReadOnly(); //13
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewAttributes3(Path path){
        try {
            DosFileAttributes attributes = Files.readAttributes(path, DosFileAttributes.class); //similar to viewAttributes2()

            attributes.lastModifiedTime(); //1
            attributes.lastAccessTime(); //2
            attributes.creationTime(); //3

            attributes.isDirectory(); //4
            attributes.isRegularFile(); //5

            attributes.isSymbolicLink(); //6
            attributes.isOther(); //7
            attributes.fileKey(); //8

            attributes.size(); //9

            attributes.isHidden(); //10
            attributes.isSystem(); //11
            attributes.isArchive(); //12
            attributes.isReadOnly(); //13
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void viewAttributes4(Path path){
        try {
            Files.getAttribute(path, "dos:lastModifiedTime"); //1
            Files.getAttribute(path, "dos:lastAccessTime"); //2
            Files.getAttribute(path, "dos:creationTime"); //3

            Files.getAttribute(path, "dos:size"); //4

            Files.getAttribute(path, "dos:isRegularFile"); //5
            Files.getAttribute(path, "dos:isDirectory"); //6
            Files.getAttribute(path, "dos:isSymbolicLink"); //7

            Files.getAttribute(path, "dos:isOther"); //8

            Files.getAttribute(path, "dos:fileKey"); //9

            Files.getAttribute(path, "dos:readonly"); //10

            Files.getAttribute(path, "dos:hidden"); //11

            Files.getAttribute(path, "dos:system"); //12
            Files.getAttribute(path, "dos:archive"); //13
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void viewAttributes5(Path path){
        try {
            Map<String, Object> attrMap = Files.readAttributes(path, "dos:*"); //gets a Map
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}