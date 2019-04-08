package com.epam.custom_exeptions;

public class EmptyFileException extends Exception {
    public EmptyFileException(String s) {
        super(s);
    }
    public String toString() {
        return "The file is empty.";
    }
}
