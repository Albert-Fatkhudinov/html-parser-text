package org.example.html.service.connection;

import org.example.html.exception.ConnectionException;

import java.io.InputStream;

/**
 * интерфейс для подключение к сайту
 * @throws ConnectionException
 */
public interface Request {

    InputStream connectToHost(String urlHtml) throws ConnectionException;
}
