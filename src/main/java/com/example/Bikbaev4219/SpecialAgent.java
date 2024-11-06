package com.example.Bikbaev4219;

import jakarta.validation.constraints.*;

import java.util.List;

public class SpecialAgent {
    @NotNull
    private String name;

    private String surname;

    @Pattern(regexp = "[0-9]{1,3}")
    private String code;

    @NotBlank
    private String status;

    @NotEmpty
    private String motto;

    @Size(min = 0, max = 4)
    private List<String> cars;

    @Min(value = 18)
    private int age;

    @Max(5)
    private int numberOfCurrentMissions;

    @Email
    private String email;

    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMotto() {
        return motto;
    }

    public List<String> getCars() {
        return cars;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfCurrentMissions() {
        return numberOfCurrentMissions;
    }

    public String getEmail() {
        return email;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberOfCurrentMissions(int numberOfCurrentMissions) {
        this.numberOfCurrentMissions = numberOfCurrentMissions;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
