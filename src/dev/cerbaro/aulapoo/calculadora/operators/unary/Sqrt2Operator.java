/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora.operators.unary;

import dev.cerbaro.aulapoo.calculadora.AbstractUnaryOperator;
import dev.cerbaro.aulapoo.calculadora.Operand;
import java.math.BigDecimal;

/**
 *
 * @author adrian
 */
public class Sqrt2Operator extends AbstractUnaryOperator {
    public static final String SQRT2_SYMBOL = String.valueOf(Character.toChars((int) 0x221A));
    
    public Sqrt2Operator() {
        super("sqrt2");
    }

    @Override
    protected void operateUnary(Operand targetOperand, BigDecimal value) {
        targetOperand.addDisplayText(SQRT2_SYMBOL + "(%s)");
        targetOperand.setValue(value.sqrt(MATH_CONTEXT));
    }
}
