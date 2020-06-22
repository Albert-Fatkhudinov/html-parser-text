package org.example.html.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс сущности Word
 * Для геттеров и сеттеров используется библиотека lombok
 */
@Entity
@Table(name = "table_words")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "count_word")
    private long numberOfRepetitions;

    public Word(String word, Integer numberOfRepetitions) {
        this.word = word;
        this.numberOfRepetitions = numberOfRepetitions;
    }
}
