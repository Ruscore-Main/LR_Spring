package com.example.Bikbaev4219.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Treadmill {
    @Id
    private String code;
    private String model;

    public Treadmill() {

    }

    public Treadmill(String code, String model) {
        this.code = code;
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public String getModel() {
        return model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setModel(String model) {
        this.model = model;
    }

}