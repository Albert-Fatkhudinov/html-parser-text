package service.response;

import java.io.IOException;
import java.io.InputStream;

public interface Response {
    String getSiteDataHtml(InputStream inputStream) throws IOException;
}
