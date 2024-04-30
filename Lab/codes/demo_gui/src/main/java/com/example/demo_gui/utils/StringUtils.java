package com.example.demo_gui.utils;

public class StringUtils {

    public static boolean isPalindrome(String word) {
        if (word.length() < 2) return true;

        int i = 0;
        int j = word.length()- 1;

        while (i < j) {
           if( word.charAt(i) != word.charAt(j)){
               return false;
           }
           i++;
           j--;
        }
        return true;
    }

}
