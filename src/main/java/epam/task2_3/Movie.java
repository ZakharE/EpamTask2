package com.epam.task2_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private String title;
    private ArrayList<Actor> cast;
    private int year;

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int year) {
        this(title);
        this.year = year;
    }

    public Movie(String title, int year, ArrayList<Actor> cast) {
        this(title, year);
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }
}
