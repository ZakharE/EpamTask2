package com.epam.task2_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor implements Serializable {
    String name;
    Date birthDay;
    ArrayList<String> cinemagraphy;

    public Actor(String name) {
        this.name = name;
        this.cinemagraphy = new ArrayList<>();
    }

    public Actor(String name, Date birthDay) {
        this(name);
        this.birthDay = birthDay;
    }

    public Actor(String name, Date birthDay, ArrayList<String> cinemagraphy) {
        this(name, birthDay);
        this.cinemagraphy = cinemagraphy;
    }


    public void addMovie(String  movie) {
        cinemagraphy.add(movie);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("My name is " + name + " ");
        result.append("and these are my movies:\n");
        for(String s : cinemagraphy){
            result.append(s + "\n");
        }
        return result.toString();
    }

}
