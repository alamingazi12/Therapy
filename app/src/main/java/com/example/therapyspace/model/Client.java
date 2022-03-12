package com.example.therapyspace.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {
    public Client(String order, String client_name, String booking_date) {
        this.order = order;
        this.client_name = client_name;
        this.booking_date = booking_date;
    }

    protected Client(Parcel in) {
        order = in.readString();
        client_name = in.readString();
        booking_date = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public String getOrder() {
        return order;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    String order;
    String client_name;
    String booking_date;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(order);
        parcel.writeString(client_name);
        parcel.writeString(booking_date);
    }
}
