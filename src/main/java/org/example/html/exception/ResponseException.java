package org.example.html.exception;

/**
 * Класс исключение - Ошибка ответа от хоста
 */
public class ResponseException extends Exception {

    public ResponseException(String message) {
        super(message);
    }
}
