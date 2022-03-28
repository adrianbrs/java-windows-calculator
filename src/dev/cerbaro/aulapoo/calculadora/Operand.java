/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrian
 */
public class Operand {
    private final CalculatorState state;
    private final List<AbstractUnaryOperator> appliedOperators = new ArrayList();
    private BigDecimal value;
    private String valueString;
    private String displayValue = null;
    private String displayText = "%s";

    public Operand(String value, CalculatorState state) {
        this.state = state;
        setValue(value);
    }
    public Operand(BigDecimal value, CalculatorState state) {
        this.state = state;
        setValue(value);
    }
    
    public String getDisplayValue() {
        return this.displayValue == null ? getValueString() : this.displayValue;
    }
    
    public boolean hasDisplayValue() {
        return this.displayValue != null;
    }
    
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayText() {
        return String.format(displayText, getDisplayValue());
    }
    
    /**
     * Engloba o displayText atual dentro do displayText informado,
     * substituindo o %s pelo displayText atual usando String.format
     * @param displayText 
     */
    public void addDisplayText(String displayText) {
        this.displayText = String.format(displayText.replace("%%", "%%%%"), this.displayText);
        update();
    }
    
    public boolean isModified() {
        return !appliedOperators.isEmpty();
    }
    
    public boolean isModifiedBy(AbstractUnaryOperator operator) {
        return appliedOperators.contains(operator);
    }
    
    public boolean isLastModifiedBy(AbstractUnaryOperator operator) {
        return this.isModified() && this.appliedOperators.get(this.appliedOperators.size() - 1) == operator;
    }
    
    public void markAsModifiedBy(AbstractUnaryOperator operator) {
        appliedOperators.add(operator);
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getValueString() {
        return valueString;
    }

    public final void setValue(String value) {
        this.value = CalculatorUtils.stringToNumber(value);
        this.valueString = value;
        update();
    }
    
    public final void setValue(BigDecimal value) {
        this.valueString = CalculatorUtils.numberToString(value);
        this.value = value;
        update();
    }
    
    private void update() {
        state.updateOperationsDisplayText();
    }

    @Override
    public String toString() {
        return getDisplayText();
    }
    
}
