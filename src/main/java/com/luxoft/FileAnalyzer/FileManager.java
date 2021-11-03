package com.luxoft.FileAnalyzer;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class FileManager {

    public static int countFiles(String path) {
        File file = new File(path);
        return recursionCountFile(file, true, 0);
    }

    public static int countDirs(String path) {
        File file = new File(path);
        return recursionCountFile(file, false, 0);
    }


    // - метод по копированию папок и файлов.
    //    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void copy(String from, String to) throws IOException {
        File folderSource = new File(from);
        File folderDestination = new File(to + File.separator + folderSource.getName());
        if (Files.exists(Paths.get(from))) {
            System.out.println("исходник существует");
            copyFile(folderSource, folderDestination);
        }
    }

    // - метод по перемещению папок и файлов.
    //    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void move(String from, String to) {
    }

    private static int recursionCountFile(File file, Boolean isFile, Integer count) {
        try {
            for (File fileFromList : file.listFiles()) {
                System.out.println(fileFromList);
                if (fileFromList.isDirectory()) {
                    if (!isFile) {
                        count++;
                    }
                    count = recursionCountFile(fileFromList, isFile, count);
                } else {
                    count++;
                }
            }
        } catch (NullPointerException e) {
            //System.out.println("Хьюстон, у нас проблеммы....");
        }
        return count;
    }

    public static boolean copyFile(File source, File dest) {
        if (Files.exists(Paths.get(String.valueOf(dest)))) {
        } else {
            try {
                Files.createDirectories(Paths.get(String.valueOf(dest)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (source.isFile()) {
            //            System.out.println("файл или папка");
            try {
                Files.copy(source.toPath(), Paths.get(String.valueOf(dest)).normalize(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("копируем папку...");
            copyDir(source, dest);
        }
        return false;
    }

    public static String copyDir(File source, File dest) {
        try {
            for (File fileFromList : source.listFiles()) {
                System.out.println("= = = " + fileFromList);
                if (fileFromList.isDirectory()) {
                    //System.out.println("Копируем папку"+);
                    File fileObject = new File(source + FileSystems.getDefault().getSeparator() + fileFromList);
                    fileObject.mkdir();
                } else {
                    System.out.println("+++++++++++++++++++++++++");
                    System.out.println(source);
                    Files.copy(source.toPath(), Paths.get(String.valueOf(dest)).normalize(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(Paths.get(String.valueOf(fileFromList)).normalize());
                    System.out.println("+++++++++++++++++++++++++");
                }
            }
        } catch (NullPointerException | IOException e) {
            //System.out.println("Хьюстон, у нас проблеммы....");
        }
        return null;
    }


    public static String createFileObject(String path, String nameFileOrDir, boolean isFile) {
        Path pathOnFileSystem = Paths.get(path).normalize();
        System.out.println(pathOnFileSystem);
        try {
            File fileObject = new File(path + FileSystems.getDefault().getSeparator() + nameFileOrDir);
            System.out.println(path + File.pathSeparator + nameFileOrDir);
            if (isFile) {
                fileObject.createNewFile();
            } else {
                fileObject.mkdir();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }


    public static ArrayList recursionListFile(File file, ArrayList listOfFile) {

        try {
            for (File fileFromList : file.listFiles()) {
                System.out.println(fileFromList.toString());
                System.out.println(" = = " + fileFromList + " = = ");
                listOfFile.add(fileFromList);
                if (fileFromList.isDirectory()) {
                    System.out.println("папка");
                }
            }
        } catch (NullPointerException e) {
            //System.out.println("Хьюстон, у нас проблеммы....");
        }
        return null;


    }

    public static void recurs(Path dirName) throws IOException {
        ArrayList file = new ArrayList();
        Files.walk(Paths.get(String.valueOf(dirName)))
                .filter(Files::isRegularFile)
                .forEach(f -> {
                            file.add(f);
                        }
                        //System.out::println
                );
//Files.copy(source.toPath(), Paths.get(String.valueOf(dest)).normalize(), StandardCopyOption.REPLACE_EXISTING);

        ArrayList dir = new ArrayList();
        Files.walk(Paths.get(String.valueOf(dirName)))
                .filter(Files::isDirectory)
                .forEach(f -> {
                    dir.add(f);
                });
        for (int i = 0; i < dir.size(); i++) {
            System.out.println("+++" + dir.get(i));
        }

    }


}