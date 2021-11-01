package com.luxoft.FileAnalyzer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FileAnalyzer {

    private String path;
    private String word;
    private int countWordInText = 0;

    public FileAnalyzer(String newPath, String newWord) {
        setPath(newPath);
        setWord(newWord);
    }

    public void startFindWord(String path) {
        File file = new File(path);
        if (file.exists() || file.isFile() || isFileHaveContent(file) || isSetFindWord(word)) {
            try (FileReader reader = new FileReader(file)) {
                char[] buf = new char[(int) file.length()];
                int data;
                while ((data = reader.read(buf)) > 0) {
                    if (data < file.length()) {
                        buf = Arrays.copyOf(buf, data);
                    }
                }
                splitSentencesInText(String.valueOf(buf));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Количество вхождений слова <" + word + "> :" + getCountWordInText());
        }
    }

    private boolean isFileHaveContent(File file) {
        return (double) file.length() > 0;
    }

    private boolean isSetFindWord(String word) {
        return word.length() > 0;
    }

    public void splitSentencesInText(String text) {
        for (String s : text.split("[.!?]")) {
            if (s.length() >= word.length()) {
                if (isWordInSentences(s.trim())) {
                    System.out.println("(+)" + s.trim());
                }
            }
        }
    }

    public boolean isWordInSentences(String sentences) {
        boolean okFind = false;
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = sentences.toLowerCase().trim().indexOf(word.toLowerCase().toLowerCase(), lastIndex);
            if (lastIndex != -1) {
                countWordInText++;
                lastIndex += word.toLowerCase().length();
                okFind = true;
            }
        }
        return okFind;
    }

    public String getPath() {
        return path;
    }

    public int getCountWordInText() {
        return countWordInText;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
