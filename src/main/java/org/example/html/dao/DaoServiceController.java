package org.example.html.dao;

import java.util.Map;

/**
 * Класс-сервис для работы с базой данных
 */
public class DaoServiceController implements DaoController {

    private final WordDao wordDao;

    public DaoServiceController(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @Override
    public boolean saveInDataBase(Map<String, Integer> count) {
        return wordDao.saveInDataBase(count);
    }
}
