package config;

import service.FileHandler;
import service.FileService;
import service.HtmlService;
import service.ServiceHandler;
import service.connection.Request;
import service.connection.RequestImpl;
import service.parse.ParserHtml;
import service.reader.HtmlFileReader;
import service.reader.ReaderFile;
import service.response.Response;
import service.response.ResponseImpl;
import service.writer.FileRecorder;
import service.writer.Recorder;
import service.CounterWord;

public class MainConfig {

    public static ServiceHandler getServiceHandler(String url) {
        Request request = new RequestImpl();
        Response response = new ResponseImpl();
        return new HtmlService(request, response, url);
    }

    public static FileHandler getFileHandler(String responseFromTheSite) {
        Recorder recorder = new FileRecorder();
        ReaderFile readerFile = new HtmlFileReader();
        return new FileService(readerFile, recorder, responseFromTheSite);
    }

    public static CounterWord getCounterWord() {
        return new CounterWord();
    }

    public static ParserHtml getParserHtml() {
        return new ParserHtml();
    }


}
