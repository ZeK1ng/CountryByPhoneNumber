package com.example.countryPhoneService.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CountryNameMapperSingleton {
    Logger logger = LoggerFactory.getLogger(CountryNameMapperSingleton.class);
    private Map<String,String> data;
    private static CountryNameMapperSingleton countryNameMapperInstance;

    private CountryNameMapperSingleton() {
        data = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            data = restTemplate.getForObject("http://country.io/names.json",data.getClass());
        }catch (RestClientException ex){
            logger.error("Can`t load data for codes. Error: "+ ex);
        }
        System.out.println(data);
        logger.info("Data Loaded");
    }
    public static CountryNameMapperSingleton getInstance(){
        if(countryNameMapperInstance == null){
            countryNameMapperInstance = new CountryNameMapperSingleton();
        }
        return countryNameMapperInstance;
    }
    public  String getCode(String key){
        if(data.containsKey(key)){
            return data.get(key);
        }
        return null;
    }
}
