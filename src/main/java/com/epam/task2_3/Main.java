package com.epam.task2_3;


import com.epam.task2_2.SymbolUtilClass;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MovieCollection collection = new MovieCollection();

        Actor a = new Actor("Leo");
        a.addMovie("Titanic");
        a.addMovie("Hate 8");
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Leo");
        cast.add("jackson");
        cast.add("sam");

        Movie m1 = new Movie("Titanic", cast);
        Movie m2 = new Movie("Hate 8", cast);
        collection.add(m1);
        collection.add(m2);

        FileOutputStream outputStream = new FileOutputStream("D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(collection);

        FileInputStream inputStream = new FileInputStream("D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        MovieCollection newMovieCollection = (MovieCollection) objectInputStream.readObject();
        System.out.println(newMovieCollection.get(1));
    }
}
