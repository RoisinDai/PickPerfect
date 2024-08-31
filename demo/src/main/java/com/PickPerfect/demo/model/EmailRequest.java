package com.PickPerfect.demo.model;

import java.io.Serializable;

public class EmailRequest implements Serializable {
    private String email;
    private String response;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "email='" + email + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
