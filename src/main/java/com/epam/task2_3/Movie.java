package com.epam.task2_3;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Movie implements Serializable {
    private String title;

    private List<Actor> cast;

    public static Comparator<Movie> comparator = Comparator.comparing(Movie::getTitle);


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
        if( o == null ) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof Movie)) {
            return false;
        }

        Movie movie = (Movie) o;

        return title.equals(movie.title);
    }
}

