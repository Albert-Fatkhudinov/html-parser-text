package org.example.html.service.file.writer;

import org.example.html.exception.FileReaderException;
import org.example.html.exception.FileWriterException;
import org.example.html.service.file.reader.HtmlFileReader;
import org.example.html.service.file.reader.ReaderFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlFileRecorderTest {

    private Recorder recorder;
    private ReaderFile readerFile;

    @BeforeEach
    public void init() {
        recorder = new HtmlFileRecorder();
        readerFile = new HtmlFileReader();
    }

    @Test
    void writeInFile() throws FileWriterException, FileReaderException {
        recorder.writeInFile("test", "src\\test\\resources\\fileWrite.txt");
        String test = readerFile.readFromFile("src\\test\\resources\\fileWrite.txt");
        assertEquals("<html>" +
                " <head></head>" +
                " <body>" +
                "  test" +
                " </body>" +
                "</html>", test);
    }
}