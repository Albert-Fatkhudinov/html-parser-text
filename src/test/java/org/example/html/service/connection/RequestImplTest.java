package org.example.html.service.connection;

import org.example.html.exception.ConnectionException;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RequestImplTest {

    @Test
    public void testConnectInputNotNull() throws ConnectionException {
        InputStream inputStream;
        Request request = new RequestImpl();
        inputStream  = request.connectToHost("https://www.codeflow.site/");
        assertNotNull(inputStream);
    }

    @Test()
    public void testConnectThrowConnectionException() throws ConnectionException {
        Request request = new RequestImpl();

        assertThrows(ConnectionException.class, () ->
                request.connectToHost("www.codeflow.site/"));
    }
}