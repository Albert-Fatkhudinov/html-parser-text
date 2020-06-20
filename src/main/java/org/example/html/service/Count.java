package org.example.html.service;

import java.util.Map;

/**
 * Интерфейс для подсчета слов
 */
public interface Count {

    Map<String, Integer> count(String[] words);
}
