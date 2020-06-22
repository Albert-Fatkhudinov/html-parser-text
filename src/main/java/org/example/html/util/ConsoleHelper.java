package org.example.html.util;

import org.example.html.exception.ReadLineException;

import java.util.Scanner;

/**
 * Класс для пользовательского ввода или вывода
 */
public class ConsoleHelper {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * @return String
     * @throws ReadLineException - в случае пустой строки
     */
    public String readString() throws ReadLineException {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            throw new ReadLineException("Пустая строка");
        }
        return line;
    }

    public void showString(String message) {
        System.out.println(message);
    }
}
