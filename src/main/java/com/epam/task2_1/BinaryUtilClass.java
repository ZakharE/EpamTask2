package com.epam.task2_1;

import com.epam.custom_exeptions.EmptyFileException;

import java.io.*;
import java.util.*;

public class BinaryUtilClass {
    static final String keywords[] = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"};

    public static void counter(String inputFileName, String outputFileName) throws IOException, EmptyFileException {
        byte[] dataFromFile;
        dataFromFile = BinaryUtilClass.readBinaryDataFromFile(inputFileName);
        if(dataFromFile.length == 0) {
            throw new EmptyFileException("File is Empty");
        }
        String stringFromBytes = new String(dataFromFile);
        Map<String, Integer> javaWordsCounter = BinaryUtilClass.javaWordsCount(stringFromBytes);
        BinaryUtilClass.writeBinaryDataToFile(javaWordsCounter, outputFileName);
    }


    public static byte[] readBinaryDataFromFile(String filePath) throws IOException {
        FileInputStream inFile = null;
        byte[] dataFromFile;
        File inputFile = new File(filePath);
        if(!inputFile.exists()) {
            throw new FileNotFoundException("Input file doesn't exist!");
        }
        inFile = new FileInputStream(filePath);
        dataFromFile = new byte[(int) inputFile.length()];
        inFile.read(dataFromFile);
        inFile.close();
        return dataFromFile;
    }

    public static String getStringFromBytes(char[] data) {
        return new String(data);
    }

    public static Map<String, Integer> javaWordsCount(String data) {
        Map<String, Integer> javaWordsCounter = new HashMap<>();

        for (String s :
                BinaryUtilClass.keywords) {
            javaWordsCounter.put(s, 0);
        }

        for (String s : data.split(" ")) {
            if (javaWordsCounter.containsKey(s)) {
                javaWordsCounter.replace(s, javaWordsCounter.get(s) + 1);
            }


        }
        return javaWordsCounter;
    }

    public static void writeBinaryDataToFile(Map<String, Integer> javaWords, String outFileName) throws IOException {
        StringBuilder beforeBinaryArray = new StringBuilder();
        for (Map.Entry<String, Integer> entry : javaWords.entrySet()) {
            if (entry.getValue() != 0) {
                beforeBinaryArray.append(entry.getKey() + ": " + entry.getValue() + "\n");
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        File outputFile = new File(outFileName);
        if(!outputFile.exists()) {
            throw new FileNotFoundException("Output file doesn't exist!");
        }
        FileOutputStream outFile = new FileOutputStream(outFileName);
        outFile.write(beforeBinaryArray.toString().getBytes());
        outFile.close();
    }
}

