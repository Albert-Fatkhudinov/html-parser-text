package org.example.html.exception;

/**
 * Класс исключение - Ошибка записи в файл
 */
public class FileWriterException extends Exception {
    public FileWriterException(String message) {
        super(message);
    }
}
