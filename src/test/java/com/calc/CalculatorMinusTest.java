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
// Some Profile with Spring etc.
// I know the name of the test should represent what the test is doing
public class CalculatorMinusTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @Mock
    private UtilsValidator utilsValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMinusOne() {
        String expression = "5-3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testMinusTwo() {
        String expression = "-5--3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testMinusThree() {
        String expression = "5--3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(8, result);
    }

    @Test
    void testMinusFour() {
        String expression = "5--3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(8, result);
    }

    @Test
    void testMinusFive() {
        String expression = "-5-3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-8, result);
    }

    @Test
    void testMinusSix() {
        String expression = "5-0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testMinusSeven() {
        String expression = "-5-0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-5, result);
    }

    @Test
    void testMinusNine() {
        String expression = "2-2-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void testMinusEight() {
        String expression = "0-0";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testCalculateWithMaxIntAndPositiveMaxIntNumberWithBrackets() {
        String expression = Integer.MAX_VALUE + "-" + Integer.MIN_VALUE;
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }


}
