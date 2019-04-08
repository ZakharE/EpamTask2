package com.epam.task2_2;

import com.epam.custom_exeptions.EmptyFileException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SymbolUtilClass {
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
        String dataFromFile;
        dataFromFile = SymbolUtilClass.readSymbolDataFromFile(inputFileName);
        if (dataFromFile.length() == 0) {
            throw new EmptyFileException("File is Empty");
        }
//        String stringFromBytes = new String(dataFromFile);
        Map<String, Integer> javaWordsCounter = SymbolUtilClass.javaWordsCount(dataFromFile);
        SymbolUtilClass.writeSymbolycDataToFile(javaWordsCounter, outputFileName);
    }


    public static String readSymbolDataFromFile(String filePath) throws IOException {
//        FileInputStream inFile = null;
//        byte[] dataFromFile;
//        File inputFile = new File(filePath);
//        if(!inputFile.exists()) {
//            throw new FileNotFoundException("Input file doesn't exist!");
//        }
//        inFile = new FileInputStream(filePath);
//        dataFromFile = inFile.readAllBytes();
//        inFile.close();
//        return dataFromFile;
        FileReader inFile = new FileReader(filePath);
        BufferedReader bufferedInFile = new BufferedReader(inFile);
        if (!inFile.ready()) {
            throw new FileNotFoundException("File not found");
        }
        StringBuilder result = new StringBuilder();
        String tmp = bufferedInFile.readLine();
        while (tmp != null) {
            result.append(tmp);
        }

        return result.toString();
    }


    public static Map<String, Integer> javaWordsCount(String data) {
        Map<String, Integer> javaWordsCounter = new HashMap<>();

        for (String s :
                SymbolUtilClass.keywords) {
            javaWordsCounter.put(s, 0);
        }

        for (String s : data.split(" ")) {
            if (javaWordsCounter.containsKey(s)) {
                javaWordsCounter.replace(s, javaWordsCounter.get(s) + 1);
            }


        }
        return javaWordsCounter;
    }

    public static void writeSymbolycDataToFile(Map<String, Integer> javaWords, String outFileName) throws IOException {
        StringBuilder dataToWrite = new StringBuilder();
        for (Map.Entry<String, Integer> entry : javaWords.entrySet()) {
            if (entry.getValue() != 0) {
                dataToWrite.append(entry.getKey() + ": " + entry.getValue() + "\n");
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        try {
            FileWriter outputFile = new FileWriter(outFileName);
            BufferedWriter bufferedOutputFile = new BufferedWriter(outputFile);


            outputFile.write(dataToWrite.toString());
            outputFile.close();
        } catch (IOException e) {
            throw e;
        }
    }
    }

