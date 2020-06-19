package service;

import service.connection.Request;
import service.response.Response;

import java.io.IOException;
import java.io.InputStream;


public class HtmlService implements ServiceHandler {

    private final Request request;
    private final Response response;
    private final String url;

    public HtmlService(Request request, Response response, String url) {
        this.request = request;
        this.response = response;
        this.url = url;
    }

    public String getResponseFromTheSite() throws IOException {
        InputStream inputStream = request.connectToHost(url);
        return response.getSiteDataHtml(inputStream);
    }
}
