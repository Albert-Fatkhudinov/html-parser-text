package org.example.html;

import org.example.html.config.MainConfig;
import org.example.html.dao.Dao;
import org.example.html.dao.WordDao;
import org.example.html.service.Count;
import org.example.html.service.FileHandler;
import org.example.html.service.ServiceHandler;
import org.example.html.exception.ConnectionException;
import org.example.html.exception.FileReaderException;
import org.example.html.exception.FileWriterException;
import org.example.html.exception.ResponseException;
import org.example.html.service.parse.Parser;
import org.example.html.util.HibernateUtil;

import java.io.IOException;
import java.util.Map;

/**
 * Класс-шаблон для логики и запуска приложения
 */
public class AppStarter {

    /**
     * @param url - имя хоста
     */
    public void start(String url)  {
        try {
            ServiceHandler serviceHandler = MainConfig.getServiceHandler(url);
            String responseFromTheSite = serviceHandler.getResponseFromTheSite();
            FileHandler handler = MainConfig.getFileHandler(responseFromTheSite);
            handler.writeFile();
            String htmlTextReadFile = handler.readFile();
            Parser parserHtml = MainConfig.getParserHtml();
            String[] parseText = parserHtml.parseHtmlInContent(htmlTextReadFile);
            Count counterWord = MainConfig.getCounterWord();
            Map<String, Integer> count = counterWord.count(parseText);
            Dao dao = new WordDao();
            boolean isComplete = dao.saveInDataBase(count);
            HibernateUtil.shutdown();
            count.forEach((key, value) -> System.out.println(key + " " + value));
        } catch (ConnectionException |
                 ResponseException |
                 IOException |
                 FileReaderException |
                 FileWriterException exception) {
                exception.printStackTrace();
        }
    }
}
