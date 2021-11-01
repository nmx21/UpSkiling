package com.luxoft.FileAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void countFiles() {
        System.out.println(FileManager.countFiles("/var/www/html/cam"));
        System.out.println(FileManager.countDirs("/var/www/html/cam"));
        System.out.println(FileManager.countFiles("/dev/null"));
        System.out.println(FileManager.countDirs("/dev/null"));
        //System.out.println(FileManager.countDirs("/"));
    }

    @Test
    void countDirs() {
    }

    @Test
    void copy() {
    }

    @Test
    void move() {
    }
}