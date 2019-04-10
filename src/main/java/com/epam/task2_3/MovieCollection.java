package com.epam.task2_3;

import java.io.Serializable;
import java.util.*;

public class MovieCollection extends AbstractList implements Serializable {

    private  ArrayList<Movie> collection;

    public MovieCollection() {
        this.collection = new ArrayList<>();
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Movie get(int index) {
        return collection.get(index);
    }

    public void add(Movie m){
        collection.add(m);
    }
}
