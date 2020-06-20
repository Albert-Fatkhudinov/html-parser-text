package org.example.html.service.reader;

import org.example.html.service.exception.FileReaderException;

import java.io.IOException;

/**
 * Интерфейс для чтения из файла
 */
public interface ReaderFile {

    String readFromFile() throws FileReaderException;
}
