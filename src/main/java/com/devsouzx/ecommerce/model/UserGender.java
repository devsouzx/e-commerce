package com.devsouzx.ecommerce.model;

public enum UserGender {
    MALE("Male"),
    FEMALE("Female");

    private String gender;

    UserGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
