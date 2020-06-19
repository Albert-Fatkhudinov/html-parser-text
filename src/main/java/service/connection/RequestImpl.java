package service.connection;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

public class RequestImpl implements Request{
    public InputStream connectToHost(String urlHtml) throws IOException {
        return new URL(urlHtml).openStream();
    }
}