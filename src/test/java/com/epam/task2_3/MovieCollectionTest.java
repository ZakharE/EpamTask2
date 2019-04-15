package com.epam.task2_3;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {
    private Actor actor;
    private MovieCollection collection;
    private ArrayList<Actor> cast;
    private MovieCollection collectionFromFile;

    @BeforeEach
    void setup() {
        cast = new ArrayList<>();
        actor = new Actor("Leo");
        cast.add(new Actor("Leo"));
        cast.add(new Actor("jackson"));
        cast.add(new Actor("sam"));
        collection = new MovieCollection();
        collection.add(new Movie("Hate 8", cast));
        cast.remove(1);
        collection.add(new Movie("Titanic", cast));

    }

    @Test
    void writeToFIle() throws IOException {

        final File expected = new File("D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out");
        String output = "D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\forCheking";
        final File result = new File(output);
        collection.writeToFIle(output);
        assertEquals(FileUtils.readLines(expected), FileUtils.readLines(expected));

    }

    @Test
    void readFromFile()  {
        String input = "D:\\Projects\\EpamTask2\\src\\main\\resources\\task2_3_resources\\save.out";

        collectionFromFile = new MovieCollection();
        collectionFromFile.readFromFile(input);
        assertEquals(collectionFromFile, collection);
    }

    @Test
    void actorCinematography() {

        ArrayList<Movie> films = new ArrayList<>();
        films.add(new Movie("Titanic"));
        films.add(new Movie("Hate 8"));

        assertEquals(films, collection.actorCinematography(actor.getName()));
    }
}