/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc.service;

import com.calc.utils.Constants;
import com.calc.utils.UtilsValidator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculatorService {

    public int calculateExpression(String expression) {
        Objects.requireNonNull(expression);
        expression = expression.replaceAll(Constants.OPERATION_WHITESPACE, Constants.EMPTY_SIGN);

        Expression exp = new ExpressionBuilder(expression).build();
        return (int) exp.evaluate();
    }

    public int calculate(String expression) {
        expression = expression.replaceAll("\\s+", "")
                .replace("++", "+")
                .replace("--", "+")
                .replace("+-", "-")
                .replace("**", "*")
                .replace("-+", "-");
        Objects.requireNonNull(expression);

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (Character.isDigit(current) ||
                    (current == '-' && (i == 0 || UtilsValidator.isOperator(expression.charAt(i - 1))))) {
                StringBuilder num = new StringBuilder();
                num.append(current);
                i++;

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i++));
                }
                numbers.push(UtilsValidator.evaluateValue(num));
                i--;
            }  else if (UtilsValidator.isOperator(current)) {
                while (!operators.isEmpty() && UtilsValidator.precedence(operators.peek()) >=
                        UtilsValidator.precedence(current) && numbers.size() >=2) {
                    processStacks(numbers, operators);
                }
                operators.push(current);
            }
        }

        while (!operators.isEmpty() && numbers.size() >=2) {
            processStacks(numbers, operators);
        }

        return numbers.pop();
    }

    private static void processStacks(Stack<Integer> numbers, Stack<Character> operators) {
        Objects.requireNonNull(numbers);
        Objects.requireNonNull(operators);
        int b = numbers.pop();
        int a = numbers.pop();

        switch (operators.pop()) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                if (b == 0) throw new IllegalArgumentException("Division by zero");
                numbers.push(a / b);
                break;
        }
    }
}
