package com.epam.task2_3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor {
    String name;
    Date birthDay;
    ArrayList<Movie> cinemagraphy;

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, Date birthDay) {
        this(name);
        this.birthDay = birthDay;
    }

    public Actor(String name, Date birthDay, ArrayList<Movie> cinemagraphy) {
        this(name, birthDay);
        this.cinemagraphy = cinemagraphy;
    }


    public void addMovie(Movie movie) {
        cinemagraphy.add(movie);
    }




}
