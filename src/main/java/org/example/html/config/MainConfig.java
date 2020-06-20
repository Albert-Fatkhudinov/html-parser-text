package org.example.html.config;

import org.example.html.service.*;
import org.example.html.service.connection.Request;
import org.example.html.service.connection.RequestImpl;
import org.example.html.service.parse.ParserHtml;
import org.example.html.service.reader.HtmlFileReader;
import org.example.html.service.reader.ReaderFile;
import org.example.html.service.response.Response;
import org.example.html.service.response.ResponseImpl;
import org.example.html.service.writer.FileRecorder;
import org.example.html.service.writer.Recorder;

/**
 * Класс для сборки сервисов
 */
public class MainConfig {

    /**
     * Метод собирает экземпляр ServiceHandler из Request(подключение к сайту), Response(ответ от сайта), url
     * @param url - входной параметр ссылка страницы.
     * @return ServiceHandler - выходной параметр, cервис подключения и ответа от сайта;
     */
    public static ServiceHandler getServiceHandler(String url) {
        Request request = new RequestImpl();
        Response response = new ResponseImpl();
        return new HtmlServiceHandler(request, response, url);
    }

    /**
     * Метод собирает экземляр FileHandler из Recorder(запись в фаил),
     * ReaderFile(чтение из файла) и html-страницы
     * @param responseFromTheSite на вход подается html-страница
     * @return FileHandler - выходной параметр, сервис записи и чтения фаила
     */
    public static FileHandler getFileHandler(String responseFromTheSite) {
        Recorder recorder = new FileRecorder();
        ReaderFile readerFile = new HtmlFileReader();
        return new FileServiceHandler(readerFile, recorder, responseFromTheSite);
    }


    /**
     * @return возвращает экземпляр класса CounterWord
     */
    public static Count getCounterWord() {
        return new CounterWord();
    }

    /**
     * @return возвращает экземпляр класса ParserHtml
     */
    public static ParserHtml getParserHtml() {
        return new ParserHtml();
    }


}
