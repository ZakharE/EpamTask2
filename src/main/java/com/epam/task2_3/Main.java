package com.epam.task2_3;


import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {

        MovieCollection collection = new MovieCollection();

        ArrayList<Actor> cast = new ArrayList<>();
        cast.add(new Actor("Leo"));
        cast.add(new Actor("jackson"));
        cast.add(new Actor("sam"));

        Movie m1 = new Movie("Titanic", cast);
        Movie m2 = new Movie("Hate 8", cast);
        System.out.println(m1.inMovie("Dio"));
        System.out.println(m1.inMovie("Leo"));
        collection.add(m1);
        collection.add(m2);

        cast.add(new Actor("Dio"));
        collection.sort(Movie.comparator);
        System.out.println(collection);

        collection.writeToFIle("D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out");
        MovieCollection collectionFromFile = new MovieCollection();
        collectionFromFile.readFromFile("D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out");

        System.out.println(collection.actorCinematography("Leo"));
    }
}
