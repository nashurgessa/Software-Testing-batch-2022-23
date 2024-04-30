package com.example.demo_gui.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }

}
