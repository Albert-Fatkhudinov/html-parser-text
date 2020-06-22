package org.example.html.service.file.reader;

import org.example.html.exception.FileReaderException;

/**
 * Интерфейс для чтения из файла
 */
public interface ReaderFile {

    String readFromFile(String fileName) throws FileReaderException;
}
