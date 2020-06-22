package org.example.html.service.connection.response;

import org.example.html.exception.ConnectionException;
import org.example.html.exception.ResponseException;
import org.example.html.service.connection.request.Request;
import org.example.html.service.connection.request.RequestImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ResponseImplTest {

    private Request request;
    private Response response;

    @BeforeEach
    public void init() {
        request = new RequestImpl();
        response = new ResponseImpl();
    }

    @Test
    void getSiteDataHtml() throws ConnectionException, ResponseException {
        InputStream inputStream  = request.connectToHost("https://www.codeflow.site/");
        String siteDataHtml = response.getSiteDataHtml(inputStream);
        assertNotNull(siteDataHtml);
    }
}