package service.writer;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;


public class FileRecorder implements Recorder {

    @Override
    public void writeInFile(String htmlText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\fileHtml.txt"))) {
            Document document = Jsoup.parse(htmlText);
            String html = document.html();
            writer.write(html);
        }
    }
}
