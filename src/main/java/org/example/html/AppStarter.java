package org.example.html;

import lombok.extern.slf4j.Slf4j;
import org.example.html.config.MainConfig;
import org.example.html.dao.DaoController;
import org.example.html.exception.*;
import org.example.html.service.counter.Count;
import org.example.html.service.file.FileHandler;
import org.example.html.service.connection.ConnectionHandler;
import org.example.html.service.parse.Parser;
import org.example.html.util.ConsoleHelper;
import org.example.html.util.HibernateUtil;

import java.io.IOException;
import java.util.Map;

/**
 * Класс-шаблон для логики приложения
 */
@Slf4j
public class AppStarter {

    ConsoleHelper consoleHelper = new ConsoleHelper();

    public void start()  {
        try {
            consoleHelper.showString("Введите имя сайта:");
            String url = consoleHelper.readString();
            if (url.equals("exit")) {
                consoleHelper.showString("Завершение приложения!");
                return;
            }
            String responseFromTheSite = getResponseFromSite(url);

            String htmlTextReadFile = getHtmlReadFile(responseFromTheSite);

            Parser parserHtml = MainConfig.getParserHtml();
            String[] parseText = parserHtml.parseHtmlInContent(htmlTextReadFile);

            Map<String, Integer> count = getStringIntegerMap(parseText);

            saveInDataBase(count);

        } catch (ConnectionException |
                ResponseException |
                IOException |
                FileReaderException |
                FileWriterException |
                ReadLineException exception) {
            exception.printStackTrace();

            consoleHelper.showString("-------------------------->>>>>>>>>>>");
            consoleHelper.showString("Ошибка -" + exception);
            consoleHelper.showString("Перезапуск приложения");
            start();
        }
    }

    private Map<String, Integer> getStringIntegerMap(String[] parseText) {
        Count counterWord = MainConfig.getCounterWord();
        Map<String, Integer> count = counterWord.count(parseText);
        count.forEach((key, value) -> System.out.println(key + " " + value));
        return count;
    }

    private void saveInDataBase(Map<String, Integer> count) {
        DaoController dao = MainConfig.getDao();
        boolean isComplete = dao.saveInDataBase(count);
        HibernateUtil.shutdown();
    }

    private String getHtmlReadFile(String responseFromTheSite) throws IOException, FileWriterException, FileReaderException {
        FileHandler handler = MainConfig.getFileHandler(responseFromTheSite);
        handler.writeFile();
        return handler.readFile();
    }

    private String getResponseFromSite(String url) throws IOException, ConnectionException, ResponseException {
        ConnectionHandler serviceHandler = MainConfig.getServiceHandler(url);
        return serviceHandler.getResponseFromTheSite();
    }
}
