package com.epam.task2_3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor implements Serializable {
    private String name;
    private Date birthDay;



    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, Date birthDay) {
        this(name);
        this.birthDay = birthDay;
    }

    public Actor(Actor actor){
        this.name = actor.name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("My name is " + name + " ");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Actor)) {
            return false;
        }

        Actor actor = (Actor) o;

        return name.equals(actor.name);
    }
}



