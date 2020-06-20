package org.example.html.service.exception;

/**
 * Класс исключение - Ошибка ответа от хоста
 */
public class ResponseException extends Exception {

    public ResponseException(String message) {
        super(message);
    }
}
