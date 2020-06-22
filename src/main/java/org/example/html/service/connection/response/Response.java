package org.example.html.service.connection.response;

import org.example.html.exception.ResponseException;

import java.io.InputStream;

/**
 * Интерфейс ответа от хоста
 */
public interface Response {
    /**
     * @param inputStream - входной поток, ответ от хоста
     * @return String - строковое представление html-страницы
     * @throws ResponseException - исключение ответа от хоста
     */
    String getSiteDataHtml(InputStream inputStream) throws ResponseException;
}
