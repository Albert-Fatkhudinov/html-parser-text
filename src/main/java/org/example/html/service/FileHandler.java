package org.example.html.service;

import org.example.html.service.exception.FileReaderException;
import org.example.html.service.exception.FileWriterException;

import java.io.IOException;

/**
 * Интерфейс сервиса для чтения и записи файла
 */
public interface FileHandler {

    void writeFile() throws IOException, FileWriterException;
    String readFile() throws IOException, FileReaderException;
}
