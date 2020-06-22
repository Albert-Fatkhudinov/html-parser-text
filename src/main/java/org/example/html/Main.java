package org.example.html;


import org.example.html.exception.ReadLineException;
import org.example.html.util.ConsoleHelper;

/**
 * Главный метод для запуска приложения
 */
public class Main {

    public static void main(String[] args) throws ReadLineException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        String url = consoleHelper.readString();
        new AppStarter().start(url);
    }
}
