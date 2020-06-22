package org.example.html.service;

import org.example.html.exception.ConnectionException;
import org.example.html.exception.ResponseException;
import org.example.html.service.response.Response;
import org.example.html.service.connection.Request;

import java.io.InputStream;


/**
 * Класс-сервис для получение информации от хоста
 */
public class HtmlServiceHandler implements ServiceHandler {

    private final Request request;
    private final Response response;
    private final String url;

    public HtmlServiceHandler(Request request, Response response, String url) {
        this.request = request;
        this.response = response;
        this.url = url;
    }

    /**
     * @return возвращает строковое представление Html-страницы
     * @throws ConnectionException - в случае если хост не отвечает или неправильно введен запрашиваемый хост
     * @throws ResponseException - в случае если произошла
     */
    public String getResponseFromTheSite() throws ConnectionException, ResponseException {
        InputStream inputStream = request.connectToHost(url);
        return response.getSiteDataHtml(inputStream);

    }
}
