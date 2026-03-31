package com.example.mysql_demo.model;

public class Specialty {

    private int id;
    private String name;
    private String description;

    public Specialty(int id, String name) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
