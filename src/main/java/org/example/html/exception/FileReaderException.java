package org.example.html.exception;

/**
 * Класс исключение - Ошибка чтения фаила
 */
public class FileReaderException extends Exception {

    public FileReaderException(String message) {
        super(message);
    }
}
