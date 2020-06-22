package org.example.html.service.parse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParserHtmlTest {

    String htmlTest = "<html><body>test1,and test2. test3</body></html>";

    @Test
    void parseHtmlInContent() {
        Parser parser = new ParserHtml();
        String[] strings = parser.parseHtmlInContent(htmlTest);
        Arrays.stream(strings).forEach(System.out::println);
    }
}