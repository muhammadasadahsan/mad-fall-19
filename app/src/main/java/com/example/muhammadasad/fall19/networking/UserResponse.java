package com.example.muhammadasad.fall19.networking;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserResponse {

    @SerializedName("firstname")
    private String firstName;

    @SerializedName("lastname")
    private String lastName;

    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private String address;
    @SerializedName("phonenumber")
    private String phoneNumber;
    @SerializedName("gender")
    private String gender;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
