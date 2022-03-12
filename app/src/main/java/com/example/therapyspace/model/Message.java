package com.example.therapyspace.model;

public class Message {

    public Message(String message_time, String message_title, String sub_title) {
        this.message_time = message_time;
        this.message_title = message_title;
        this.sub_title = sub_title;
    }

    public String getMessage_time() {
        return message_time;
    }

    public String getMessage_title() {
        return message_title;
    }

    public String getSub_title() {
        return sub_title;
    }

    String message_time;
    String message_title;
    String sub_title;
}
