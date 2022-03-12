package com.example.therapyspace.model;

public class ModelActivity {
    public ModelActivity(String title, String date_time, String sub_title, int image_source) {
        this.title = title;
        this.date_time = date_time;
        this.sub_title = sub_title;
        this.image_source = image_source;
    }

    String title;
    String date_time;
    String sub_title;
    int image_source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public int getImage_source() {
        return image_source;
    }

    public void setImage_source(int image_source) {
        this.image_source = image_source;
    }
}
