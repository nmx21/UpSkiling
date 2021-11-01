package com.luxoft.FileAnalyzer;


import java.io.File;

//    Пишем class FileManager с методами
public class FileManager {


    // принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) {
        File file = new File(path);
    return recursionFile(file,true, 0);
    }

    // public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) {
        File file = new File(path);
        return recursionFile(file,false, 0);
    }

    // - метод по копированию папок и файлов.
    //    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void copy(String from, String to) {

    }

    // - метод по перемещению папок и файлов.
    //    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void move(String from, String to) {
    }

    private static int recursionFile(File file, Boolean isFile, Integer count){
        try {
        for (File fileFromList:file.listFiles()){
            if (fileFromList.isDirectory()){
                if(!isFile){count++;}
                count = recursionFile(fileFromList,isFile, count);
            }else{count++;}
        }
        } catch (NullPointerException e) {
            //System.out.println("Хьюстон, у нас проблеммы....");
        }
        return count;
    }




}