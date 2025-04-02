/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.mathparser;

import com.calc.expfourj.MathParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MathPraserTest {
    @InjectMocks
    private MathParser mathParser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testFor4JOne() {
        String expression = "2 + 3";
        Assertions.assertEquals(5, mathParser.calculate(expression));
    }

    @Test
    void testFor4JTwo() {
        String expression = "3 * 2 + 1";
        Assertions.assertEquals(7, mathParser.calculate(expression));
    }

    @Test
    void testFor4JThree() {
        String expression = "3 * -2 + 6";
        Assertions.assertEquals(0, mathParser.calculate(expression));
    }


}
