package org.example.html.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordDaoTest {

    Map<String, Integer> count;

    @BeforeEach
    public void init() {
        count = new HashMap<>();
    }

    @Test
    public void saveInDataBase() {
        count.put("hello", 2);
        count.put("test", 1);
        WordDao dao = new WordDao();
        boolean testSaveInDataBase = dao.saveInDataBase(count);
        assertTrue(testSaveInDataBase);
    }
}