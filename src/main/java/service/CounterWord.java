package service;

import java.util.HashMap;
import java.util.Map;

public class CounterWord {

    public Map<String, Integer> count(String[] words) {
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word: words) {
            String upperCaseWord = word.toUpperCase();
            mapWords.merge(upperCaseWord, 1, Integer::sum);
        }
        return mapWords;
    }
}
