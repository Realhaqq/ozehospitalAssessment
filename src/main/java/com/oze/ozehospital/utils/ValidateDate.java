package com.oze.ozehospital.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateDate {
    public boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {

            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM-dd-yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

}