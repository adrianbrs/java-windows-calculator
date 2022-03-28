/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.math.MathContext;

/**
 *
 * @author adrian
 */
public abstract class AbstractOperator {
    private final String operationCode;
    private CalculatorState state;
    
    protected final MathContext MATH_CONTEXT = MathContext.DECIMAL64;

    public AbstractOperator(String operationCode) {
        this.operationCode = operationCode;
    }
    
    public final void setState(CalculatorState state) {
        this.state = state;
    }
    
    public final CalculatorState getState() {
        return state;
    }
    
    public boolean isUnaryOperator() {
        return false;
    }

    public String getOperationCode() {
        return operationCode;
    }
    
    public String getOperationDisplayText() {
        return getOperationCode();
    }
    
    public abstract void operate();

    @Override
    public String toString() {
        return getOperationDisplayText();
    }
}
