package com.example.countryPhoneService.responce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryResponce {
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
