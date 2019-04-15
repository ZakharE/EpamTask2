package com.epam.task2_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Movie implements Serializable {
    private String title;

    private ArrayList<Actor> cast;

    public static Comparator<Movie> comparator = Comparator.comparing(obj -> obj.getTitle());


    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, ArrayList<Actor> cast) {
        this(title);
        this.cast = new ArrayList<>(cast.stream().map(Actor::new).collect(Collectors.toList()));
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }

    public boolean inMovie(String actorName) {
        return cast.stream().anyMatch(x -> x.getName().equals(actorName));
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Movie)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Movie movie = (Movie) o;

        // Compare the data members and return accordingly
        return title.equals(movie.title);
    }
}

