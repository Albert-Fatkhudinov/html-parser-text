package service.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResponseImpl implements Response {

    public String getSiteDataHtml(InputStream inputStream) throws IOException {
        StringBuilder htmlToStringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String htmlStringLine;
            while ((htmlStringLine = reader.readLine()) != null) {
                htmlToStringBuilder.append(htmlStringLine);
            }
        }
        return htmlToStringBuilder.toString();
    }
}
