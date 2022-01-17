package com.example.countryPhoneService.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CountryNumberMapperSingleton {
    Logger logger = LoggerFactory.getLogger(CountryNumberMapperSingleton.class);
    private  Map<String,String> data;
    private static CountryNumberMapperSingleton countryNumberMapInstance;

    private CountryNumberMapperSingleton() {
        data = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            data = restTemplate.getForObject("http://country.io/phone.json",data.getClass());
        }catch (RestClientException ex){
            logger.error("Can`t load data for codes. Error: "+ ex);
        }
        System.out.println(data);
        logger.info("Country number mapper Loaded");
    }
    public static CountryNumberMapperSingleton getInstance(){
        if(countryNumberMapInstance == null){
            countryNumberMapInstance = new CountryNumberMapperSingleton();
        }
        return countryNumberMapInstance;
    }
    public  String getCountry(String value){
        try {
            return data.entrySet().stream().filter(entry-> value.equals(entry.getValue())).map(Map.Entry::getKey).findFirst().get();
        }catch (NoSuchElementException ex){
            return "";
        }
    }
}
