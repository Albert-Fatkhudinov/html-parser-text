package org.example.html.service.reader;

import lombok.extern.slf4j.Slf4j;
import org.example.html.service.exception.FileReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Класс для чтения файла
 */
@Slf4j
public class HtmlFileReader implements ReaderFile {

    /**
     * @return возвращает строковое представление из файла
     * @throws FileReaderException - возникает, если фаил не найден или возникает исключение IOException
     * Чтение происходит из файла fileHtml.txt которое находится на диске D:\
     */
    @Override
    public String readFromFile() throws FileReaderException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\fileHtml.txt", StandardCharsets.UTF_8))) {
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException exception) {
            log.info("Ошибка чтения фаила");
            throw new FileReaderException("Ошибка чтения фаила");
        }
        return stringBuilder.toString();
    }
}
