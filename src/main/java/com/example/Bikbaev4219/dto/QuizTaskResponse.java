package com.example.Bikbaev4219.dto;

import com.example.Bikbaev4219.entities.Option;

import java.util.List;

public class QuizTaskResponse {
    private long id;
    private List<String> options;

    public QuizTaskResponse() {

    }

    public QuizTaskResponse(long id, List<String> options) {
        this.id = id;
        this.options = options;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
