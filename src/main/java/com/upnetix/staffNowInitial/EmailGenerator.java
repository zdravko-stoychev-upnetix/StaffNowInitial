package com.upnetix.staffNowInitial;

import org.apache.commons.lang.RandomStringUtils;

public class EmailGenerator {

    public static String generateRandomEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String randomeEmail = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        randomeEmail = temp.substring(0, temp.length()-9) + "@gmail.com";
        return randomeEmail;


    }

}
