package org.example.html.service.file;

import org.example.html.exception.FileReaderException;
import org.example.html.exception.FileWriterException;
import org.example.html.service.file.reader.ReaderFile;
import org.example.html.service.file.writer.Recorder;

/**
 * Класс для чтения и записи файла
 */
public class FileServiceHandler implements FileHandler {

    private final ReaderFile readerFile;
    private final Recorder recorder;
    private final String htmlString;

    public static final String FILE_PATH
            = "src\\main\\resources\\fileHtml.txt";

    public FileServiceHandler(ReaderFile readerFile, Recorder recorder, String htmlString) {
        this.readerFile = readerFile;
        this.recorder = recorder;
        this.htmlString = htmlString;
    }

    /**
     * @throws FileWriterException - в случае ошибки ввода/вывода
     * метод записывает в файл html-страницу
     */
    @Override
    public void writeFile() throws FileWriterException {
        recorder.writeInFile(htmlString, FILE_PATH);
    }

    /**
     * @return возвращает строковое представление из файла
     * @throws FileReaderException - в случае ошибки ввода вывода
     * метод считвает из файла html-страницу
     */
    @Override
    public String readFile() throws FileReaderException {
        return readerFile.readFromFile(FILE_PATH);
    }
}
