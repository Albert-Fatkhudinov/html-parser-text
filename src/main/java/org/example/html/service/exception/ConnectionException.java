package org.example.html.service.exception;

/**
 * Класс-исключение - ошибки подключения к хосту
 * или неправельно задано имя хоста
 */
public class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }
}
