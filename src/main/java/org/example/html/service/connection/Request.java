package org.example.html.service.connection;

import org.example.html.service.exception.ConnectionException;

import java.io.IOException;
import java.io.InputStream;

/**
 * интерфейс для подключение к сайту
 * @throws ConnectionException
 */
public interface Request {

    InputStream connectToHost(String urlHtml) throws ConnectionException;
}
