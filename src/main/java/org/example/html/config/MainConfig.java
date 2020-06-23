package org.example.html.config;

import org.example.html.dao.DaoServiceController;
import org.example.html.dao.WordDao;
import org.example.html.service.connection.ConnectionServiceHandler;
import org.example.html.service.connection.request.Request;
import org.example.html.service.connection.request.RequestImpl;
import org.example.html.service.connection.ConnectionHandler;
import org.example.html.service.counter.Count;
import org.example.html.service.counter.CounterWord;
import org.example.html.service.file.FileHandler;
import org.example.html.service.file.FileServiceHandler;
import org.example.html.service.parse.ParserHtml;
import org.example.html.service.file.reader.HtmlFileReader;
import org.example.html.service.file.reader.ReaderFile;
import org.example.html.service.connection.response.Response;
import org.example.html.service.connection.response.ResponseImpl;
import org.example.html.service.file.writer.HtmlFileRecorder;
import org.example.html.service.file.writer.Recorder;

/**
 * Класс для сборки сервисов
 */
public class MainConfig {

    /**
     * Метод собирает экземпляр ServiceHandler из Request(подключение к сайту), Response(ответ от сайта), url
     * @param url - входной параметр ссылка страницы.
     * @return ServiceHandler - выходной параметр, cервис подключения и ответа от сайта;
     */
    public static ConnectionHandler getServiceHandler(String url) {
        Request request = new RequestImpl();
        Response response = new ResponseImpl();
        return new ConnectionServiceHandler(request, response, url);
    }

    /**
     * Метод собирает экземляр FileHandler из Recorder(запись в фаил),
     * ReaderFile(чтение из файла) и html-страницы
     * @param responseFromTheSite на вход подается html-страница
     * @return FileHandler - выходной параметр, сервис записи и чтения фаила
     */
    public static FileHandler getFileHandler(String responseFromTheSite) {
        Recorder recorder = new HtmlFileRecorder();
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

    /**
     * @return возвращает экземпляр класса DaoService
     */
    public static DaoServiceController getDao() {
        return new DaoServiceController(new WordDao());
    }


}
