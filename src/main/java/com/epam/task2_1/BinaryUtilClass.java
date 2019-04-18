package com.epam.task2_1;

import com.epam.UtilWordCount;
import com.epam.custom_exeptions.EmptyFileException;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class BinaryUtilClass {


    public static void counter(String inputFileName, String outputFileName) throws IOException, EmptyFileException {
        byte[] dataFromFile;
        dataFromFile = BinaryUtilClass.readBinaryDataFromFile(inputFileName);
        if(dataFromFile.length == 0) {
            throw new EmptyFileException("File is Empty");
        }
        String stringFromBytes = new String(dataFromFile);
        Map<String, Integer> javaWordsCounter = UtilWordCount.javaWordsCount(stringFromBytes);
        BinaryUtilClass.writeBinaryDataToFile(javaWordsCounter, outputFileName);
    }


    public static byte[] readBinaryDataFromFile(String filePath) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (BufferedInputStream br =
                     new BufferedInputStream(new FileInputStream(filePath))
        ) {
            int readByte = 0;
            while ((readByte = br.read()) != -1) {
                byteArrayOutputStream.write(readByte);
            }
            return byteArrayOutputStream.toByteArray();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        } catch (IOException e) {
            System.out.println("Input error");
            throw e;
        }



    }

    public static String getStringFromBytes(char[] data) {
        return new String(data);
    }


    public static void writeBinaryDataToFile(Map<String, Integer> javaWords, String outFileName) throws IOException {
        StringBuilder beforeBinaryArray = new StringBuilder();
        for (Map.Entry<String, Integer> entry : javaWords.entrySet()) {
            if (entry.getValue() != 0) {
                beforeBinaryArray.append(entry.getKey() + ": " + entry.getValue() + "\n");
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        try(BufferedOutputStream br = new BufferedOutputStream(new FileOutputStream(outFileName))){
          br.write(beforeBinaryArray.toString().getBytes());
        }
    }
}

