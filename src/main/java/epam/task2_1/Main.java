package com.epam.task2_1;

import com.epam.custom_exeptions.EmptyFileException;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String inFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test4.in";
        String outFileName = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_1_resources\\test4.out";



        try {
            BinaryUtilClass.counter(inFileName,outFileName);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }

    }
}
