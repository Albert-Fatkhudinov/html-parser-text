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
            ConnectionHandler serviceHandler = MainConfig.getServiceHandler(url);
            String responseFromTheSite = serviceHandler.getResponseFromTheSite();

            FileHandler handler = MainConfig.getFileHandler(responseFromTheSite);
            handler.writeFile();
            String htmlTextReadFile = handler.readFile();

            Parser parserHtml = MainConfig.getParserHtml();
            String[] parseText = parserHtml.parseHtmlInContent(htmlTextReadFile);

            Count counterWord = MainConfig.getCounterWord();
            Map<String, Integer> count = counterWord.count(parseText);

            DaoController dao = MainConfig.getDao();
            boolean isComplete = dao.saveInDataBase(count);
            HibernateUtil.shutdown();
            count.forEach((key, value) -> System.out.println(key + " " + value));
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
}
