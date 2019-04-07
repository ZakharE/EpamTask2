package com.epam.task2_3;

import com.opencsv.CSVReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "D:\\Projects\\IOstreams\\src\\main\\resources\\task2_3_resources\\tmdb_5000_credits.csv";
        FileReader filereader = new FileReader(file);

        // create csvReader object passing
        // file reader as a parameter
        CSVReader csvReader = new CSVReader(filereader);

        List<String[]> data = csvReader.readAll();

        System.out.println(data);

    }
}
