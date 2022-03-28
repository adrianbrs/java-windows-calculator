/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora.operators.unary;

import dev.cerbaro.aulapoo.calculadora.AbstractUnaryOperator;
import dev.cerbaro.aulapoo.calculadora.CalculatorState;
import dev.cerbaro.aulapoo.calculadora.CalculatorUtils;
import dev.cerbaro.aulapoo.calculadora.Operand;
import java.math.BigDecimal;

/**
 *
 * @author adrian
 */
public class PercentOperator extends AbstractUnaryOperator {
    
    public PercentOperator() {
        super("%");
    }

    @Override
    protected boolean isStaticOperandValue() {
        return false;
    }

    @Override
    protected void operateUnary(Operand targetOperand, BigDecimal value) {
        CalculatorState state = getState();
        
        if (state.getLeftOperand() == targetOperand) {
            targetOperand.setValue(BigDecimal.ZERO);
            return;
        }
        
        if (targetOperand.isLastModifiedBy(this)) {
            return;
        }
        
        if (!targetOperand.hasDisplayValue()) {
            targetOperand.setDisplayValue(CalculatorUtils.numberToString(value));
        }
        
        BigDecimal leftOperandValue = state.getLeftOperand() != null ? state.getLeftOperand().getValue() : BigDecimal.ZERO;
        targetOperand.addDisplayText("%s%%");
        targetOperand.setValue(value.divide(BigDecimal.valueOf(100d)).multiply(leftOperandValue));
    }
}
