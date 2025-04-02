/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc;

import com.calc.service.CalculatorService;
import com.calc.utils.UtilsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// Yes it should be given when then - I knew it
public class CalculatorDivideTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @Mock
    private UtilsValidator utilsValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateWithPositiveAndPositiveNumber() {
        String expression = "6/3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testCalculateWithPositiveAndPositiveNumberWithBracket() {
        String expression = "6/3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testCalculateWithPositiveAndNegativeNumber() {
        String expression = "5/2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testCalculateWithPositiveAndNegativeNumberWithBrackets() {
        String expression = "-6/-3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testCalculateWithNegativeAndNegativeNumber() {
        String expression = "6/-3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testCalculateWithNegativeAndNegativeNumberWithBrackets() {
        String expression = "-6/3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }


    @Test
    void testCalculateWithNegativeAndZeroNumber() {
        String expression = "5/0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(expression);
        });
    }



    @Test
    void testCalculateWithMaxIntAndPositiveMaxIntNumberWithBrackets() {
        String expression = Integer.MIN_VALUE + "/" + Integer.MAX_VALUE;
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-1, result);
    }
    @Test
    void testMaxByMin() {
        String expression = Integer.MAX_VALUE + "/" + Integer.MIN_VALUE;
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }


}
