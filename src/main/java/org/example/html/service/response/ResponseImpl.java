package org.example.html.service.response;

import lombok.extern.slf4j.Slf4j;
import org.example.html.service.exception.ResponseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Класс для получения ответа от хоста
 */
@Slf4j
public class ResponseImpl implements Response {

    /**
     * @param inputStream - входной поток, ответ от хоста
     * @return возвращает стриноговое представление html-страницы
     * @throws ResponseException - возникает при ошибке ввода-вывода IOException
     */
    public String getSiteDataHtml(InputStream inputStream) throws ResponseException {
        StringBuilder htmlToStringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String htmlStringLine;
            while ((htmlStringLine = reader.readLine()) != null) {
                htmlToStringBuilder.append(htmlStringLine);
            }
        } catch (IOException exception) {
            log.info("Ошибка ввода - вывода");
            throw new ResponseException("Ошибка ввода - вывода");
        }
        return htmlToStringBuilder.toString();
    }
}
