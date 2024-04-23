package com.example.demo_gui2.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailPasswordValidator {

    public boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9_+.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern emailPart = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPart.matcher(email);
        boolean result = matcher.matches();
        return  result;
    }

    public boolean isPasswordValid(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{6,24}$";
        Pattern emailPart = Pattern.compile(passwordRegex);
        Matcher matcher = emailPart.matcher(password);
        boolean result = matcher.matches();
        return result;
    }
}
