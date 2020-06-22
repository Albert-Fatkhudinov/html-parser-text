package org.example.html.service.file;

import org.example.html.exception.FileReaderException;
import org.example.html.exception.FileWriterException;

import java.io.IOException;

/**
 * Интерфейс сервиса для чтения и записи файла
 */
public interface FileHandler {

    void writeFile() throws IOException, FileWriterException;
    String readFile() throws IOException, FileReaderException;
}
