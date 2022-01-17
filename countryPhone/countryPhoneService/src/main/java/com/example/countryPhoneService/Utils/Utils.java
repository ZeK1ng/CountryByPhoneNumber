package com.example.countryPhoneService.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    public static Boolean validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length()<7 || phoneNumber.length()>15){
            return false;
        }
//        Pattern p = Pattern.compile(
//                "^(\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
//        Pattern p = Pattern.compile("^\\+(?:[0-9]●?){6,14}[0-9]$");
        Pattern p = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
        Matcher m = p.matcher(phoneNumber);

        return m.matches();
    }
}
