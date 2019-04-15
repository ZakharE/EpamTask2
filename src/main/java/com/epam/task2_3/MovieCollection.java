package com.epam.task2_3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MovieCollection  implements Serializable {

    private  ArrayList<Movie> collection;

    public MovieCollection() {
        this.collection = new ArrayList<>();
    }

    public void writeToFIle(String path){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {

            objectOutputStream.writeObject(collection);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }

    public void readFromFile(String path)  {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            collection = (ArrayList<Movie>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("it is not a movie collection. Try another file!");
        }
    }

    public List<Movie> actorCinematography(String actorName) {
        return collection.stream().filter(x -> x.inMovie(actorName)).collect(Collectors.toList());
    }

    public int size() {
        return collection.size();
    }


    public Movie get(int index) {
        return collection.get(index);
    }

    public void add(Movie m){
        collection.add(m);
    }


    public void remove(int index) {
        collection.remove(index);
    }


    public void clear() {
        collection.clear();
    }


    public boolean isEmpty() {
        return collection.isEmpty();
    }


    public void sort(Comparator c) {
        collection.sort(c);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        collection.forEach(x -> result.append(x + "\n"));
        return result.toString();
    }


}
