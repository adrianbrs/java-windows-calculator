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
public class Pow2Operator extends AbstractUnaryOperator {
    public static String SYMBOL = String.valueOf(Character.toChars((int) 0x00B2));
    
    public Pow2Operator() {
        super("x^2");
    }

    @Override
    protected void operateUnary(Operand targetOperand, BigDecimal value) {
        targetOperand.addDisplayText("(%s)" + SYMBOL);
        targetOperand.setValue(value.pow(2, MATH_CONTEXT));
    }
}
