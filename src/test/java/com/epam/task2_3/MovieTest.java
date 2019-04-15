package com.epam.task2_3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    private ArrayList<Actor> cast;
    private Movie movie;
    @BeforeEach
    void setup() {
        cast = new ArrayList<>();
        cast.add(new Actor("Leo"));
        cast.add(new Actor("jackson"));
        cast.add(new Actor("sam"));

        movie = new Movie("Titanic", cast);
    }

    @Test
    void inMovie() {
        assertTrue(movie.inMovie("Leo"), "Actor in movie");
        assertFalse(movie.inMovie("NO Name"), "Actor not in movie");
    }
}