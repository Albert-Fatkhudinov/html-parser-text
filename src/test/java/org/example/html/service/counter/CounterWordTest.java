package org.example.html.service.counter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterWordTest {

    String[] testStrings = new String[]{"test", "test", "test",
                                        "Count", "Count",
                                        "word"};

    @Test
    void count() {
        CounterWord counterWord = new CounterWord();
        Map<String, Integer> countTest = counterWord.count(testStrings);
        assertEquals(3, countTest.get("TEST"));
        assertEquals(2, countTest.get("COUNT"));
        assertEquals(1, countTest.get("WORD"));
    }
}