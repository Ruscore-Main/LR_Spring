package com.example.Bikbaev4219.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

@Entity
public class QuizTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String text;

    @Size(min = 2)
    @OneToMany(mappedBy = "quizTask", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @OneToMany(mappedBy = "quizTask", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answer = new ArrayList<>();

    // Конструктор
    public  QuizTask() {

    }

    public QuizTask(String title, String text) {
        this.title = title;
        this.text = text;
        //this.options.addAll(options);
        //this.answer.addAll(trueAnswerIndexes);
    }

    public boolean isTrueAnswers(List<Integer> answerIndexes) {
        answerIndexes.replaceAll(integer -> integer - 1);
        Collections.sort(answerIndexes);
        Collections.sort(answer, (o1, o2) -> o2.getTrueAnswerIndex() - o1.getTrueAnswerIndex());

        if (answer.size() == answerIndexes.size()) {
            int countTrue = 0;
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i).getTrueAnswerIndex() == answerIndexes.get(i)) {
                    countTrue++;
                }
            }

            return countTrue == answer.size();
        }

        return  false;
    }

    // Геттеры
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<Answer> getAnswer() {
        return answer;
    }


    // Сеттеры
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setAnswer(List<Answer> trueAnswerIndexes) {
        this.answer = trueAnswerIndexes;
    }
}
