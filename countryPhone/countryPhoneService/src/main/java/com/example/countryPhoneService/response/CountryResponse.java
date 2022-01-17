package com.example.countryPhoneService.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryResponse {
    @JsonProperty
    private String name;

    @JsonProperty
    private String errorMessage;


    public CountryResponse() {

    }

    public CountryResponse(String name) {
        this.name = name;
    }

    public CountryResponse(String name, String errorMessage) {
        this.name = name;
        this.errorMessage = errorMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "name='" + name + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
