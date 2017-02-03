package com.bankappmvc.helpers;

import org.apache.commons.lang3.math.NumberUtils;

public class Validation {
    public static String checkForInt(String toNumber, int limit) {
        if (!NumberUtils.isNumber(toNumber)) {
            return "enter a valid number";
        } else if(NumberUtils.toInt(toNumber) < limit) {
            return "must be greater than or equal to " + limit;
        }
        return "";
    }

    public static String checkForEmailSimple(String email) {
        if(email == null || "".equalsIgnoreCase(email)) {
            return "must not be blank";
        } else if(!email.contains("@")) {
            return "not a well-formed email address";
        }
        return "";
    }
}
