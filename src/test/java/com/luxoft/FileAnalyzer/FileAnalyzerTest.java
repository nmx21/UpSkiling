package com.luxoft.FileAnalyzer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class FileAnalyzerTest {


    @Test
    void startFindWord() {
        // TODO
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);

    }

    @Test
    void splitSentencesInText() {
        // TODO
    }

    @Test
    void isWordInSentences() {
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        String someText = "Halloween is both the scariest and funniest holiday of the year. It is celebrated on the night of October 31 to November 1 and has very long roots. It is believed that Halloween comes from the Celtic festival of the evil spirits of Samhain.";
        Assert.assertTrue(fileAnalyzer.isWordInSentences(someText));
        Assert.assertFalse(fileAnalyzer.isWordInSentences("123"));

    }

    @Test
    void getPath() {
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        fileAnalyzer.setPath(path);
        Assert.assertEquals("/home/maks/test.txt", fileAnalyzer.getPath());
    }

    @Test
    void getCountWordInText(String someText) {
        //someText = "Halloween is both the scariest and funniest holiday of the year. It is celebrated on the night of October 31 to November 1 and has very long roots. It is believed that Halloween comes from the Celtic festival of the evil spirits of Samhain.";
        //Assert.assertEquals(16,getCountWordInText(someText));


    }

    @Test
    void setPath() {
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        fileAnalyzer.setPath(path);
        Assert.assertEquals("/home/maks/test.txt", fileAnalyzer.getPath());
    }

    @Test
    void setWord() {
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        fileAnalyzer.setWord("Zet");
        Assert.assertEquals("Zet", fileAnalyzer.getWord());
    }

    @Test
    void setNullWord() {
        String path = "/home/maks/test.txt";
        String word = null;
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        fileAnalyzer.setWord(word);
        Assert.assertNull(fileAnalyzer.getWord());
    }

    @Test
    void getWord() {
        String path = "/home/maks/test.txt";
        String word = "I";
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path, word);
        Assert.assertEquals("I", fileAnalyzer.getWord());
    }
}