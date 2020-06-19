package service.connection;

import java.io.IOException;
import java.io.InputStream;

public interface Request {

    InputStream connectToHost(String urlHtml) throws IOException;
}
