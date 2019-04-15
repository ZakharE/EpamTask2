package com.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UtilWordCount {
    static final String keywords[] = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"};


    public static Map<String, Integer> javaWordsCount(String data) {
        Map<String, Integer> javaWordsCounter = new HashMap<>();

        for (String s : data.split(" ")) {
            if (javaWordsCounter.containsKey(s)) {
                javaWordsCounter.replace(s, javaWordsCounter.get(s) + 1);
            } else {
                if(Arrays.stream(keywords).anyMatch(x -> x.equals(s))) {
                    javaWordsCounter.put(s, 1);
                }
            }


        }
        return javaWordsCounter;
    }
}
