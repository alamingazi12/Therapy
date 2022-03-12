package com.example.therapyspace.model;

public class Document {
    public Document(String doc_name, String doc_date) {
        this.doc_name = doc_name;
        this.doc_date = doc_date;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(String doc_date) {
        this.doc_date = doc_date;
    }

    String doc_name;
    String doc_date;
}
