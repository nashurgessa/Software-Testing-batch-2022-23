package org.example.todo_demo.utils;

public class StringUtils {
    /**
     * Checks if a given string is a palindrome, ignoring case and non-alphanumeric characters.
     * @param str the string to check
     * @return true if str is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            // Move i forward if current character is a number
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            // move j forward if the current character is a number
            while (i < j && !Character.isLetterOrDigit(str.charAt(j))) {
                j ++;
            }

            // Check if the character at current i and j are different
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
