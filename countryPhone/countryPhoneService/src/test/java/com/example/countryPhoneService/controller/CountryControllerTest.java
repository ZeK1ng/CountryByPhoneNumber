package com.example.countryPhoneService.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CountryControllerTest {
    Logger logger = LoggerFactory.getLogger(CountryControllerTest.class);
    @Autowired
    private MockMvc mockMvc;
    private final String baseUrl = "/getCountry?phoneNumber=";

    @Test
    void getCountry() throws Exception {
        logger.info("-------Starting CountryController tests ------");
        logger.info("Testing /getCountry for number: 995598322837");
        mockMvc.perform(get(baseUrl + "995598322837")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Georgia")));
        logger.info("Testing /getCountry for number: 262123412312");
        mockMvc.perform(get(baseUrl + "262123412312")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Reunion")));
        logger.info("Testing /getCountry for invalid number format");
        mockMvc.perform(get(baseUrl + "abcasd2312a")).andExpect(status().isBadRequest()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("")))
                .andExpect(jsonPath("$.errorMessage",is("Bad Number")));
        logger.info("Testing /getCountry for not found number format");
        mockMvc.perform(get(baseUrl + "33312311231")).andExpect(status().isNotFound()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("")))
                .andExpect(jsonPath("$.errorMessage",is("Can`t Find any country with this phone number")));
        logger.info("------- CountryController tests ended ------");
    }

}