package org.example.html.service;

import org.example.html.service.exception.ConnectionException;
import org.example.html.service.exception.ResponseException;

import java.io.IOException;

/**
 * Класс-сервис для получение ответа от хоста
 */
public interface ServiceHandler {

    String getResponseFromTheSite() throws IOException, ConnectionException, ResponseException;
}
