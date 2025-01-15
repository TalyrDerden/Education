package org.example;

import java.util.ArrayList;
import java.util.function.Function;

public class Opstrings {
    public static String vertMirror (String strng) {
        String[] words = strng.split("\n");
        var revert = new ArrayList(words.length);
        for (String word : words) {
            revert.add(new StringBuilder(word).reverse().toString());
        }
        String result = String.join("\n", revert);
        return result;
    }
    public static String horMirror (String strng) {
        String[] words = strng.split("\n");
        var revert = new ArrayList(words.length);

        for (int i = 0; i< words.length; i++) {
            revert.add(new StringBuilder(words[words.length-i-1]));
        }
        String result = String.join("\n", revert);
        return result;
    }
    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
}
