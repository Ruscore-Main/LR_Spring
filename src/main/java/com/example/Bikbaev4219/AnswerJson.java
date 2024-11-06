package com.example.Bikbaev4219;

import jakarta.validation.constraints.Size;

import java.util.List;

public class AnswerJson {
    private List<Integer> answer;

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
