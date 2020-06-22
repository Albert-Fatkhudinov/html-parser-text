package org.example.html.service.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Данный класс производит очистку от тэгов Html
 * используется библиотека Jsoup
 */
public class ParserHtml implements Parser {

    /**
     * @param html - документ html подается в виде строки
     * @return возвращает распарсеный массив слов
     */
    public String[] parseHtmlInContent(String html) {
        Document document = Jsoup.parse(html);
        String titleText = document.title();
        String bodyText = document.body().text();
        String fullText = titleText + bodyText;
        return Arrays.stream(fullText.split("[\\s\\]\\[,.!)?(\";:\\n\\r\\t]"))
                .map(String::trim)
                .map(i -> i.split(" "))
                .flatMap(Arrays::stream)
                .filter(word -> !word.equals(""))
                .toArray(String[]::new);
    }
}
