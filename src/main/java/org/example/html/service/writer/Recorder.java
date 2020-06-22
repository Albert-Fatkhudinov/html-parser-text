package org.example.html.service.writer;

import org.example.html.exception.FileWriterException;

/**
 * Интерфейс для записи в файл
 */
public interface Recorder {

    void writeInFile(String htmlText) throws FileWriterException;
}
