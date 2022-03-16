package com.example.therapyspace.model;

public class Note {
    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public int getNote_image() {
        return note_image;
    }

    public int getBig_image() {
        return big_image;
    }

    String title;
    String desc;
    String date;
    int note_image,big_image;

    public Note(String title, String desc, String date, int note_image, int big_image) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.note_image = note_image;
        this.big_image = big_image;
    }



}
