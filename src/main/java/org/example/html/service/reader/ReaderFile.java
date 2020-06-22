package org.example.html.service.reader;

import org.example.html.exception.FileReaderException;

/**
 * Интерфейс для чтения из файла
 */
public interface ReaderFile {

    String readFromFile() throws FileReaderException;
}
