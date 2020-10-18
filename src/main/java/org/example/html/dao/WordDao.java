package org.example.html.dao;

import org.example.html.entity.Word;
import org.example.html.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

/**
 * Класс для подключения к базе данных(Hibernate)
 * и занесения данных в таблицу БД
 */
public class WordDao {

    /**
     * Метод применятся для подключения к БД(PostgresSQL)
     * и для сохранения данных в таблицу.
     * Применяется транзакция, в случае ошибки транзакция откатывается.
     * @param count - map (слово, количество вхождений в тексте)
     * @return boolean если все успешно возвращает true, иначе false
     * Запрос "INSERT INTO words VALUES (?, ?)"
     *
     */
    public boolean saveInDataBase(Map<String, Integer> count) {
        boolean isComplete = false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            count.forEach((key, value) -> session.save(new Word(key, value)));
            transaction.commit();
            isComplete = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isComplete;
    }
}
