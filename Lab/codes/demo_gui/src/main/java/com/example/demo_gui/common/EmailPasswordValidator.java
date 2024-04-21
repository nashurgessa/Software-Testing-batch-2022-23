package com.example.demo_gui.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailPasswordValidator {

    public boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9_+.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern emailPart = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPart.matcher(email);
        boolean result = matcher.matches();
        System.out.println("email matcher : " + result);
        // return result;
        return true;

    }

    public boolean isPasswordValid(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{6,24}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPattern.matcher(password);
        boolean result = matcher.matches();
        System.out.println("password matcher : " + result);
        // return result; //matcher.matches();
        return true;
    }

}
