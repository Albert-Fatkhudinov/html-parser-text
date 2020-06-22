package org.example.html.dao;


import java.util.Map;

/**
 * Интерфейс дао для CRUD операции
 */
public interface DaoController {

    boolean saveInDataBase(Map<String, Integer> count);
}
