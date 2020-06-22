package org.example.html.service.connection.request;

import org.example.html.exception.ConnectionException;

import java.io.InputStream;

/**
 * интерфейс для подключение к сайту
 */
public interface Request {

    InputStream connectToHost(String urlHtml) throws ConnectionException;
}
