package com.example.countryPhoneService.service;


import com.example.countryPhoneService.data.CountryNameMapperSingleton;
import com.example.countryPhoneService.data.CountryNumberMapperSingleton;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public String getCountryCodeName(String phonePrefix){
        CountryNumberMapperSingleton countryNumberMapperSingleton = CountryNumberMapperSingleton.getInstance();
        return countryNumberMapperSingleton.getCountry(phonePrefix);
    }

    public String getCountryNameByCode(String countryCodeName) {
        CountryNameMapperSingleton countryNameMapperSingleton = CountryNameMapperSingleton.getInstance();
        return countryNameMapperSingleton.getCountryFullName(countryCodeName);
    }
}
