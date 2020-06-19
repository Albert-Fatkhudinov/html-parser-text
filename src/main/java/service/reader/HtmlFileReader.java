package service.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HtmlFileReader implements ReaderFile {

    @Override
    public String readFromFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\fileHtml.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
}
