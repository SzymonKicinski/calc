/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc.utils;


import java.util.Map;

public class UtilsValidator {

    private static final Map<Character, Integer> OPERATORS = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2,
            '^', 3
    );
    public static boolean isOperator(char c) {
        return OPERATORS.containsKey(c);
    }

    public static int precedence(char operator) {
        return OPERATORS.getOrDefault(operator, -1);
    }

    public static int evaluateValue(StringBuilder num) {
        long value = Long.parseLong(num.toString());
        return (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, value));
    }

    public static boolean isRightAssociative(char operator) {
        return operator == '^';
    }
}
