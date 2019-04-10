package com.epam.task2_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Movie implements Serializable {
    private String title;
    private ArrayList<String> cast;

    public Movie(String title) {
        this.title = title;
    }


    public Movie(String title, ArrayList<String> cast) {
        this(title);
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return title;
    }


}
