package org.example.html.dao;


import java.util.Map;

/**
 * Интерфейс дао для CRUD операции
 */
public interface Dao {

    boolean saveInDataBase(Map<String, Integer> count);
}
