package com.example.greeting.model;

public class GreetingModel {

    private String name;

    public GreetingModel() {
    }

    public GreetingModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
