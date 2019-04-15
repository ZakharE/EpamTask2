package com.epam.task2_2;

import com.epam.custom_exeptions.EmptyFileException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inFileName = "D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_2_resources\\test4.in";
        String outFileName = "D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_2_resources\\test4.out";



        try {
            SymbolUtilClass.counter(inFileName,outFileName);
        } catch(IOException e) {
            System.out.println("oh no");
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }
}
