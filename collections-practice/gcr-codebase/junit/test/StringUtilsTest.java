package com.example.junit_demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testReverseEmptyString() {
        assertEquals("", utils.reverse(""));
    }

    @Test
    void testIsPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }

    @Test
    void testToUpperCaseWithNumbers() {
        assertEquals("JAVA123", utils.toUpperCase("java123"));
    }

    // null handling
    @Test
    void testNullInput() {
        assertNull(utils.reverse(null));
        assertFalse(utils.isPalindrome(null));
        assertNull(utils.toUpperCase(null));
    }
}
