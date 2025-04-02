/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc;

import com.calc.service.CalculatorService;
import com.calc.ui.CalculatorUI;
import com.calc.utils.UtilsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DoubleOperatorTest {

    @InjectMocks
    private CalculatorService calculatorService;
    @Mock
    private UtilsValidator utilsValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlusMinus() {
        String expression = "2+-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testMinusMinus() {
        String expression = "2--2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testPlusPlus() {
        String expression = "2-+2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }


    @Test
    void testMinusMinusMinus() {
        String expression = "2-2-2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(-2, result);
    }


    @Test
    void testOne() {
        String expression = "3 * 2 + 1";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(7, result);
    }
    @Test
    void testTwo() {
        String expression = "2 + 3";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testThree() {
        String expression = "3 * -2 + 6";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(0, result);
    }


}
