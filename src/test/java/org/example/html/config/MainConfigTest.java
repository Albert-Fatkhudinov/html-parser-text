package org.example.html.config;

import org.example.html.dao.DaoController;
import org.example.html.service.counter.Count;
import org.example.html.service.file.FileHandler;
import org.example.html.service.connection.ConnectionHandler;
import org.example.html.service.parse.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainConfigTest {

    @Test
    void getServiceHandlerNotNull() {
        ConnectionHandler serviceHandler = MainConfig.getServiceHandler("https://www.test.com");
        assertNotNull(serviceHandler);
    }

    @Test
    void getFileHandlerNotNull() {
        FileHandler fileHandler = MainConfig.getFileHandler("<html>test</html>");
        assertNotNull(fileHandler);
    }

    @Test
    void getCounterWordNotNull() {
        Count countTest = MainConfig.getCounterWord();
        assertNotNull(countTest);
    }

    @Test
    void getParserHtmlNotNull() {
        Parser parser = MainConfig.getParserHtml();
        assertNotNull(parser);
    }

    @Test
    void getDaoNotNull() {
        DaoController daoController = MainConfig.getDao();
        assertNotNull(daoController);
    }
}