package com.example.therapyspace.model;

public class Billing {
    String billing_title;

    public Billing(String billing_title, String billing_Sub_title, int billing_amount) {
        this.billing_title = billing_title;
        this.billing_Sub_title = billing_Sub_title;
        this.billing_amount = billing_amount;
    }

    public String getBilling_title() {
        return billing_title;
    }

    public String getBilling_Sub_title() {
        return billing_Sub_title;
    }

    public int getBilling_amount() {
        return billing_amount;
    }

    String billing_Sub_title;
    int billing_amount;
}
