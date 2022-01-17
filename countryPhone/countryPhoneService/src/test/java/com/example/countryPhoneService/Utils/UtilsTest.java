package com.example.countryPhoneService.Utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;


class UtilsTest {
    Logger logger = LoggerFactory.getLogger(UtilsTest.class);
    @Test
    void validatePhoneNumber() {
        logger.info("-------Starting Validation Tests----------");
        assertTrue(Utils.validatePhoneNumber("+995555223311"));
        assertFalse(Utils.validatePhoneNumber("995544223311"));
        assertFalse(Utils.validatePhoneNumber("+1-24222313212"));
        assertFalse(Utils.validatePhoneNumber("+124abcda212asda"));
        assertFalse(Utils.validatePhoneNumber("+995123123123523968201295869123018"));
        assertFalse(Utils.validatePhoneNumber("#a@sdahbwkpoasnn"));
        assertFalse(Utils.validatePhoneNumber(""));
        assertFalse(Utils.validatePhoneNumber("      "));
        assertFalse(Utils.validatePhoneNumber("+1123"));
        logger.info("-------Validation Tests Ended------------");
    }
}