package org.example.html.service.writer;

import org.example.html.service.exception.FileWriterException;

import java.io.IOException;

/**
 * Интерфейс для записи в файл
 */
public interface Recorder {

    void writeInFile(String htmlText) throws FileWriterException;
}
