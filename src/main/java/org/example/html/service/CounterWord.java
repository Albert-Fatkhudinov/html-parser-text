package org.example.html.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для подсчета слов
 */
public class CounterWord implements Count {

    /**
     * @param words - массив строк из html-страницы без тэгов
     * @return возвращает отоброжение (Key - слово, value - сколько раз встречается в тексте)
     */
    public Map<String, Integer> count(String[] words) {
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word: words) {
            String upperCaseWord = word.toUpperCase();
            mapWords.merge(upperCaseWord, 1, Integer::sum);
        }
        return mapWords;
    }
}
