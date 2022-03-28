/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora.operators;

import dev.cerbaro.aulapoo.calculadora.AbstractOperator;
import dev.cerbaro.aulapoo.calculadora.CalculatorState;

/**
 *
 * @author adrian
 */
public class SumOperator extends AbstractOperator {
    public static String SYMBOL = String.valueOf(Character.toChars((int) 0x002B));

    public SumOperator() {
        super("+");
    }

    @Override
    public String getOperationDisplayText() {
        return SYMBOL;
    }

    @Override
    public void operate() {
        CalculatorState state = getState();
        state.setResult(state.getLeftOperand().getValue().add(state.getRightOperand().getValue(), MATH_CONTEXT));
    }
}
