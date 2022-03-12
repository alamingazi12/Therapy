package com.example.therapyspace.model;

public class Place {
    public Place(String name, String c_type, String time) {
        this.name = name;
        this.c_type = c_type;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getC_type() {
        return c_type;
    }

    public String getTime() {
        return time;
    }

    String name;
    String c_type;
    String time;
}
