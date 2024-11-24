package com.example.Bikbaev4219.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int trueAnswerIndex;

    // Связь Many-to-One с QuizTask, указываем автора твита
    @ManyToOne
    @JoinColumn(name = "quizTask_id", nullable = false)
    @JsonIgnore // предотвращает бесконечную рекурсию
    private QuizTask quizTask;

    public Answer() {

    }
    public  Answer(int trueAnswerIndex) {
        this.trueAnswerIndex = trueAnswerIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setQuizTask(QuizTask quizTask) {
        this.quizTask = quizTask;
    }

    public int getTrueAnswerIndex() {
        return trueAnswerIndex;
    }

    public void setTrueAnswerIndex(int trueAnswerIndex) {
        this.trueAnswerIndex = trueAnswerIndex;
    }
}
