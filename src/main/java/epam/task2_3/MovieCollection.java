package com.epam.task2_3;

import java.util.*;

public class MovieCollection extends LinkedList {
    private List<Movie> collection;

    public MovieCollection() {
        collection = new ArrayList<>();
    }
    public void addMovie(Movie movie) {
        collection.add(movie);
    }
    public Movie getMovie(String title) {
        if(collection.contains(title)){
            return collection.get()
        }
    }

    public boolean contains(String title) {
        for (Movie m:
             collection) {
            if(m.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }
}
