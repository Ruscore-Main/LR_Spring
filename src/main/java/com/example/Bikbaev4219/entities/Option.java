package com.example.Bikbaev4219.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String option;

    @ManyToOne
    @JoinColumn(name = "quizTask_id", nullable = false)
    @JsonIgnore // предотвращает бесконечную рекурсию
    private QuizTask quizTask;


    public Option() {

    }
    public  Option(String option) {
        this.option = option;
    }

    public long getId() {
        return id;
    }

    public void setQuizTask(QuizTask quizTask) {
        this.quizTask = quizTask;
    }

    public String getOption() {
        return option;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
