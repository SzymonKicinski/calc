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

public class CalculatorPowerTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @Mock
    private UtilsValidator utilsValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void powerTest() {
        String expression = "2^3^2";
        int result = calculatorService.calculate(expression);
        Assertions.assertEquals(512, result);
    }


}
