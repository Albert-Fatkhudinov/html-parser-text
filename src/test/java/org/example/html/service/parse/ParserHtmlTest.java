package org.example.html.service.parse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParserHtmlTest {

    String htmlTest = "<html><body>test1,and test2. test3</body></html>";

    @Test
    void parseHtmlInContent() {

        String[] testString = new String[]{"test1", "and", "test2", "test3"};
        Parser parser = new ParserHtml();
        String[] strings = parser.parseHtmlInContent(htmlTest);
        assertArrayEquals(strings, testString);
    }
}