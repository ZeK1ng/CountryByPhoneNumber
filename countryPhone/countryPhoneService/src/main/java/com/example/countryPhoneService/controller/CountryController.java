package com.example.countryPhoneService.controller;

import com.example.countryPhoneService.Utils.Utils;
import com.example.countryPhoneService.response.CountryResponse;
import com.example.countryPhoneService.service.CountryService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class CountryController {
    Logger logger = LoggerFactory.getLogger(CountryController.class);
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/getCountry")
    @ResponseBody
    public ResponseEntity<CountryResponse> getCountry(@RequestParam String phoneNumber) {
        logger.info(String.format("----- /getCountry called with param: %s ----- ",phoneNumber));
        phoneNumber = "+" + phoneNumber;
        boolean isValidPhoneNumber = Utils.validatePhoneNumber(phoneNumber);
        System.out.println(phoneNumber);
        if (!isValidPhoneNumber) {
            return new ResponseEntity<>(new CountryResponse("", "Bad Number"), HttpStatus.BAD_REQUEST);
        }
        String numberPrefix = phoneNumber.substring(1,4);
        logger.info("-----Phone validation passed. Phone prefix is: "+numberPrefix+"-----");
        String countryCodeName = countryService.getCountryCodeName(numberPrefix);
        String fullCountryName = countryService.getCountryNameByCode(countryCodeName);
        if(fullCountryName == null || fullCountryName.equals("")){
            logger.error("Country not found for number: "+ phoneNumber);
            return new ResponseEntity<>(new CountryResponse("", "Can`t Find any country with this phone number"), HttpStatus.NOT_FOUND);
        }
        CountryResponse resp = new CountryResponse();
        resp.setName(fullCountryName);
        logger.info("------ Sending Response:"+resp.toString()+"----");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    private String validate(String phoneNumber) {
        return "";
    }

}
