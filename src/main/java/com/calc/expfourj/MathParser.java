/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.calc.expfourj;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
// First approach - the way we should do this. IMO
public class MathParser {

    public int calculate(String expression) {

        Expression exp = new ExpressionBuilder(expression).build();
        return (int) Math.round(exp.evaluate());
    }
}
