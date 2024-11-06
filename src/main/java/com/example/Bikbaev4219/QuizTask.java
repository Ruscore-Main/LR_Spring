package com.example.Bikbaev4219;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Collections;

import java.util.List;

public class QuizTask {
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    @Size(min = 2)
    private List<String> options;

    private List<Integer> answer;

    // Конструктор
    public QuizTask(int id, String title, String text, List<String> options, List<Integer> trueAnswerIndexes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = trueAnswerIndexes;
    }

    public boolean isTrueAnswers(List<Integer> answerIndexes) {
        answerIndexes.replaceAll(integer -> integer - 1);
        Collections.sort(answerIndexes);
        Collections.sort(answer);

        return answer.equals(answerIndexes);
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

    public List<String> getOptions() {
        return options;
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

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(List<Integer> trueAnswerIndexes) {
        this.answer = trueAnswerIndexes;
    }
}
