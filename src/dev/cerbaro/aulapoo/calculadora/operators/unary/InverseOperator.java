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
public class InverseOperator extends AbstractUnaryOperator {

    public InverseOperator() {
        super("1/x");
    }

    @Override
    protected void operateUnary(Operand targetOperand, BigDecimal value) {
        targetOperand.addDisplayText("1/(%s)");
        targetOperand.setValue(BigDecimal.ONE.divide(value, MATH_CONTEXT));
    }
}
