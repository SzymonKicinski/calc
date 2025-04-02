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
public class CalculatorAddTest {

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
        String expression = "2+2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testCalculateWithPositiveAndPositiveNumberWithBracket() {
        String expression = "2+2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testCalculateWithPositiveAndNegativeNumber() {
        String expression = "2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testCalculateWithPositiveAndNegativeNumberWithBrackets() {
        String expression = "2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testCalculateWithNegativeAndNegativeNumber() {
        String expression = "-2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-4, result);
    }

    @Test
    void testCalculateWithNegativeAndNegativeNumberWithBrackets() {
        String expression = "-2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-4, result);
    }


    @Test
    void testCalculateWithNegativeAndZeroNumber() {
        String expression = "-2+0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testCalculateWithZeroAndNegativeNumber() {
        String expression = "0+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testCalculateWithPositiveAndZeroNumberWithBrackets() {
        String expression = "2+0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }


    @Test
    void testCalculateWithZeroAndZeroNumberWithBrackets() {
        String expression = "0+0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }


    @Test
    void testCalculateWithNegativeNumberAndPositiveNumberBrackets() {
        String expression = "5+-3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }
    @Test
    void testCalculatePositiveNumberWithNegativeNumberBrackets() {
        String expression = "3+-5";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testCalculateWithNegativeZeroAndNegativeZeroNumberWithBrackets() {
        String expression = "-0+-0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testZeroOne() {
        String expression = "5+0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testZeroTwo() {
        String expression = "-5+0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-5, result);
    }
    @Test
    void testCalculateWithNegativeNumberAndNegativeNumberNumberWithBrackets() {
        String expression = "-2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-4, result);
    }

    @Test
    void testCalculateWithMaxIntAndPositiveMaxIntNumberWithBrackets() {
        String expression =  Integer.MIN_VALUE + "+" + Integer.MAX_VALUE;
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-1, result);
    }


}
