package com.devsouzx.ecommerce.domain.user;

public enum UserGender {
    MALE("male"),
    FEMALE("female");

    private String gender;

    UserGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
