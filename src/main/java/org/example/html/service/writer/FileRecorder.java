package org.example.html.service.writer;


import lombok.extern.slf4j.Slf4j;
import org.example.html.exception.FileWriterException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс для чтения из файла
 */
@Slf4j
public class FileRecorder implements Recorder {

    /**
     * @param htmlText - html-страница в строковом представление
     * @throws FileWriterException -  в случае ошибки ввода вывода
     * Метод записывает html-страницу в файл fileHtml.txt который находится на диске D:\
     */
    @Override
    public void writeInFile(String htmlText) throws FileWriterException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\fileHtml.txt", StandardCharsets.UTF_8))) {
            Document document = Jsoup.parse(htmlText);
            String html = document.html();
            writer.write(html);
        } catch (IOException exception) {
            exception.printStackTrace();
            log.info("Ошибка ввода - вывода");
            throw new FileWriterException("Ошибка ввода - вывода");
        }
    }
}
