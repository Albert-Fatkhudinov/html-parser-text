package org.example.html.util;

import org.example.html.exception.ReadLineException;

import java.util.Scanner;

public class ConsoleHelper {

    private final Scanner scanner = new Scanner(System.in);

    public String readString() throws ReadLineException {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            throw new ReadLineException("Пустая строка");
        }
        return line;
    }
}
