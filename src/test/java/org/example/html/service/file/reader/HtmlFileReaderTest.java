package org.example.html.service.file.reader;

import org.example.html.exception.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlFileReaderTest {

    @Test
    void readFromFile() throws FileReaderException {
        String test = "test";
        ReaderFile readerFile = new HtmlFileReader();
        String stringFromTestFile = readerFile.readFromFile("src/test/resources/fileTest.txt");
        assertEquals(test, stringFromTestFile);
    }
}