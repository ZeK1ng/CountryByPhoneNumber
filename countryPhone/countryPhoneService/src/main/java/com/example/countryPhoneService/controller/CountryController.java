package com.example.countryPhoneService.controller;

import com.example.countryPhoneService.responce.CountryResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class CountryController {

    @GetMapping("/test")
    public void test(){

    }
    @GetMapping("/getCountry")
    public ResponseEntity<CountryResponce> getCountry(){
        CountryResponce resp = new CountryResponce();
        resp.setName("GEO");
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

}
