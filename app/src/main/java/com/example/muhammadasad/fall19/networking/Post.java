package com.example.muhammadasad.fall19.networking;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private String firstName;

    @SerializedName("title")
    private String lastName;

    @SerializedName("userId")
    private String userID;

    @SerializedName("body")
    private String body;

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
