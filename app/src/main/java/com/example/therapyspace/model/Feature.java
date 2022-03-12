package com.example.therapyspace.model;

public class Feature {
    public Feature(int number, String feature, int res_id) {
        this.number = number;
        this.feature = feature;
        this.res_id = res_id;
    }

    public int getNumber() {
        return number;
    }

    public String getFeature() {
        return feature;
    }

    public int getRes_id() {
        return res_id;
    }

    int number;
    String feature;
    int res_id;
}
