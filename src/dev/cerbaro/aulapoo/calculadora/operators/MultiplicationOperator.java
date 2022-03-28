/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora.operators;

import dev.cerbaro.aulapoo.calculadora.AbstractOperator;
import dev.cerbaro.aulapoo.calculadora.CalculatorState;
import dev.cerbaro.aulapoo.calculadora.Operand;

/**
 *
 * @author adrian
 */
public class MultiplicationOperator extends AbstractOperator {
    public static final String SYMBOL = String.valueOf(Character.toChars((int) 0x00D7));

    public MultiplicationOperator() {
        super("*");
    }

    @Override
    public String getOperationDisplayText() {
        return SYMBOL;
    }

    @Override
    public void operate() {
        CalculatorState state = getState();
        state.setResult(state.getLeftOperand().getValue().multiply(state.getRightOperand().getValue(), MATH_CONTEXT));
    }
}
