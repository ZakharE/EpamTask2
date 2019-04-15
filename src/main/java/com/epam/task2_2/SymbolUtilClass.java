package com.epam.task2_2;

import com.epam.UtilWordCount;
import com.epam.custom_exeptions.EmptyFileException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

public class SymbolUtilClass {


    public static void counter(String inputFileName, String outputFileName) throws IOException, EmptyFileException {
        String dataFromFile;
        dataFromFile = SymbolUtilClass.readSymbolDataFromFile(inputFileName);
        if (dataFromFile.length() == 0) {
            throw new EmptyFileException("File is Empty");
        }
        Map<String, Integer> javaWordsCounter = UtilWordCount.javaWordsCount(dataFromFile);
        SymbolUtilClass.writeSymbolycDataToFile(javaWordsCounter, outputFileName);
    }


    public static String readSymbolDataFromFile(String filePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder result = new StringBuilder();
            String tmp ;
            while ((tmp = br.readLine()) != null) {
                result.append(tmp);
            }
            return result.toString();
        }
        catch (IOException e) {
            throw e;
        }

    }



    public static void writeSymbolycDataToFile(Map<String, Integer> javaWords, String outFileName) throws IOException {

        try(BufferedWriter br = new BufferedWriter(new FileWriter(outFileName))) {

            StringBuilder dataToWrite = new StringBuilder();
            for (Map.Entry<String, Integer> entry : javaWords.entrySet()) {
                if (entry.getValue() != 0) {
                    dataToWrite.append(entry.getKey() + ": " + entry.getValue() + "\n");
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
            br.write(dataToWrite.toString());
        }
        catch (IOException e) {
            throw e;
        }
    }
    }

