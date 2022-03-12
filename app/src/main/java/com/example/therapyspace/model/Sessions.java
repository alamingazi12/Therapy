package com.example.therapyspace.model;

public class Sessions {
    String name;

    public Sessions(String name, String date_time, String c_type, String time) {
        this.name = name;
        this.date_time = date_time;
        this.c_type = c_type;
        this.time = time;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    String date_time;

    public Sessions(String name, String c_type, String time) {
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

    String c_type;
    String time;
}
