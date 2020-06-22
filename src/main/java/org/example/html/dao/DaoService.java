package org.example.html.dao;

import java.util.Map;

/**
 * Класс-сервис для работы с базой данных
 */
public class DaoService implements DaoController {

    private final WordDao wordDao;

    public DaoService(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @Override
    public boolean saveInDataBase(Map<String, Integer> count) {
        return wordDao.saveInDataBase(count);
    }
}
