package org.example.html.service.connection.request;

import lombok.extern.slf4j.Slf4j;
import org.example.html.exception.ConnectionException;

import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс реализует интерфейс Request.
 * Предназначен для подключению к сайту
 */
@Slf4j
public class RequestImpl implements Request{

    /**
     * @param urlHtml - имя домена, обязательно с протоколом(MalformedURLException)
     * @return - возвращает поток ввода при удачном подключене
     * @throws ConnectionException - При возникновение IOException или
     * если неправильно написано имя сайто
     */
    public InputStream connectToHost(String urlHtml) throws ConnectionException {
        try {
            return new URL(urlHtml).openStream();
        } catch (MalformedURLException exception) {
            log.info("Не указан протокол");
            throw new ConnectionException("Не указан протокол");
        } catch (IOException exception) {
            log.info("Ошибка ввода-вывода");
            throw new ConnectionException("Ошибка ввода-вывода");
        }
    }
}