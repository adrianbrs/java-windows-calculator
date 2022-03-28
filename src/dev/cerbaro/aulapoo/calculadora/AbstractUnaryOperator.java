/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.math.BigDecimal;

/**
 *
 * @author adrian
 */
public abstract class AbstractUnaryOperator extends AbstractOperator {

    public AbstractUnaryOperator(String operationCode) {
        super(operationCode);
    }

    @Override
    public final boolean isUnaryOperator() {
        return true;
    }

    @Override
    public void operate() {
        CalculatorState state = getState();
        String input = state.getInput();
        BigDecimal inputValue = state.getInputValue();
        
        // Quando há um resultado exibido, deve resetar
        if (state.isResultShown()) {
            state.clearState();
        }
        
        Operand targetOperand;
        
        if (state.getOperator() != null) {
            targetOperand = state.getRightOperand();
            
            if (targetOperand == null) {
                state.setRightOperand(BigDecimal.ZERO);
                targetOperand = state.getRightOperand();
            }
        } else {
            targetOperand = state.getLeftOperand();
            
             if (targetOperand == null) {
                state.setLeftOperand(BigDecimal.ZERO);
                targetOperand = state.getLeftOperand();
            }
        }
        
        if (isStaticOperandValue() && !targetOperand.hasDisplayValue()) {
            targetOperand.setDisplayValue(input);
        }
        operateUnary(targetOperand, inputValue);
        targetOperand.markAsModifiedBy(this);

        state.setInput(targetOperand.getValueString());
    }
    
    protected boolean isStaticOperandValue() {
        return true;
    }
    
    protected abstract void operateUnary(Operand targetOperand, BigDecimal value);
}
