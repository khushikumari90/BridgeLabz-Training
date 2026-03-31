package com.example.junit_demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            utils.divide(10, 0);
        });
    }

    //  Optional: test normal division
    @Test
    void testDivideSuccess() {
        assertEquals(5, utils.divide(10, 2));
    }
}
