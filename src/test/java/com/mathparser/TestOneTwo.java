/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.mathparser;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
// Test of library ExpressionBuilder - it's good to use it IMO also
public class TestOneTwo {

    @Test
    public void testOne() {
        String expression = "2-2-(-(-2))";

        Expression exp = new ExpressionBuilder(expression).build();

        double result = exp.evaluate();

        int intValue = (int) result;

        Assertions.assertEquals(-2, intValue);

        System.out.println("Wynik: " + intValue);
    }
}
