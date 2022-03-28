/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.math.BigDecimal;
import javax.swing.JButton;

/**
 *
 * @author 178304
 */
public class CalculatorState {
    private BigDecimal result = BigDecimal.ZERO;
    private BigDecimal inputValue = BigDecimal.ZERO;
    private boolean dirty = false;
    private boolean resultShown = false;
    private String error = null;
    
    private Operand leftOperand = null;
    private AbstractOperator operator = null;
    private Operand rightOperand = null;
    
    private final JFCalculadora calculatorInstance;

    public CalculatorState(JFCalculadora calculatorInstance) {
          this.calculatorInstance = calculatorInstance;
          clearState();
    }
    
    public boolean isDirty() {
        return this.dirty;
    }
    
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    
    public boolean isResultShown() {
        return this.resultShown;
    }
    
    public void setResultShown(boolean shown) {
        if (getLeftOperand() == null) {
            this.resultShown = false;
        } else {
            this.resultShown = shown;
        }
        updateOperationsDisplayText();
    }

    public BigDecimal getResult() {
        return result;
    }
    
    public String getResultString() {
        return CalculatorUtils.numberToString(getResult());
    }

    public void setResult(String result) {
        setResult(CalculatorUtils.stringToNumber(result));
    }
    
    public void setResult(BigDecimal result) {
        setInput(result);
        this.result = result;
    }
    
    public void clearResult() {
        setResult(BigDecimal.ZERO);
    }
    
    public void setInput(BigDecimal input) {
        inputValue = input;
        setPlainInput(CalculatorUtils.numberToString(input));
    }
    
    public void setInput(String input) {
        // Se houver um resultado exibido, limpa o estado atual
        if (isResultShown()) {
            clearState();
        } else {
            clearError();
        }
        
        String sep = CalculatorUtils.getDecimalSeparator();
        
        // Verifica se o número está completo para formatar, caso contrário, define o input
        // com o valor parcial digitado até o momento. Isso é necessário pois ao diginal zero a direita
        // após o separador decimal, ao formatar esses valores são removidos
        try {
            if (!input.endsWith(sep) && (!input.contains(sep) || !input.endsWith("0"))) {
                inputValue = CalculatorUtils.stringToNumber(input);
                input = CalculatorUtils.numberToString(inputValue);
            }
        } catch (Exception ex) {}
        
        setPlainInput(input);
    }
    
    public void setPlainInput(String plainInput) {
        calculatorInstance.jLabelInput.setText(plainInput);
    }
    
    public void clearInput() {
        setInput("0");
    }
    
    public String getInput() {
        return calculatorInstance.jLabelInput.getText();
    }
    
    public BigDecimal getInputValue() {
        return inputValue;
    }
    
    public Operand getLeftOperand() {
        return leftOperand;
    }
    
    public Operand getRightOperand() {
        return rightOperand;
    }
    
    public void setLeftOperand(String value) {
        setLeftOperand(new Operand(value, this));
    }
    
    public void setLeftOperand(BigDecimal value) {
        setLeftOperand(new Operand(value, this));
    }
    
    public void setLeftOperand(Operand operand) {
        this.leftOperand = operand;
        updateOperationsDisplayText();
    }
    
    public void clearLeftOperand() {
        setLeftOperand((Operand) null);
    }
    
    public void setRightOperand(String value) {
        setRightOperand(new Operand(value, this));
    }
    
    public void setRightOperand(BigDecimal value) {
        setRightOperand(new Operand(value, this));
    }
    
    public void setRightOperand(Operand operand) {
        this.rightOperand = operand;
        updateOperationsDisplayText();
    }
    
    public void clearRightOperand() {
        setRightOperand((Operand) null);
    }
    
    public void clearOperands() {
        clearLeftOperand();
        clearRightOperand();
    }
    
    public void updateOperationsDisplayText() {
        if (getLeftOperand() != null) {
            String displayText = getLeftOperand().getDisplayText();
            
            if (getOperator() != null) {
                displayText = getLeftOperand() + " " + getOperator();
                
                if (getRightOperand() != null) {
                    displayText += " " + getRightOperand();
                }
            }
            
            if (isResultShown()) {
                displayText += " =";
            }
            
            calculatorInstance.jLabelOperations.setText(displayText);
        } else {
            calculatorInstance.jLabelOperations.setText("");
        }
    }
    
    public void setOperation(String operation) {
        if (operation != null) {
            setOperator(calculatorInstance.getOperator(operation));            
        } else {
            setOperator(null);
        }
    }
    
    public AbstractOperator getOperator() {
        return this.operator;
    }
    
    public void setOperator(AbstractOperator operator) {
        // Executa operadores unários assim que forem usados
        if (operator != null && operator.isUnaryOperator()) {
            executeOperator(operator);
            return;
        }
        this.operator = operator;
        setResultShown(false);
        updateOperationsDisplayText();
        
        // Ao trocar o operador sempre deve preparar para a próxima operação
        if (getLeftOperand() != null && getRightOperand() != null) {
            setLeftOperand(getResult());
            clearRightOperand();
        }
    }
    
    public void clearOperator() {
        setOperator(null);
    }
    
    public final void clearState() {
        setDirty(true);
        setResultShown(false);
        clearResult();
        clearInput();
        clearOperator();
        clearOperands();
        clearError();
    }
    
    public void eraseInput() {
        if (isResultShown()) {
            clearState();
            return;
        }
        
        if (!isDirty()) {
            cleanupNonDirtyInput();
            return;
        }
        
        String input = getInput();
        
        if (input.length() == 1) {
            clearInput();
        } else {
            setInput(input.substring(0, input.length() - 1));            
        }
    }
    
    public void cleanupNonDirtyInput() {
        if (!isDirty()) {
            if (getOperator() != null) {
                clearInput();
                
                if (getRightOperand() != null && getRightOperand().isModified()) {
                    clearRightOperand();
                }
            } else {
                clearState();
            }
        }
    }
    
    public void clearInputOrState() {
        if (getOperator() == null) {
            clearState();
        } else {
            clearInput();
            cleanupNonDirtyInput();
        }
    }
    
    public void handleInputCommand(String input) {
        clearError();
        cleanupNonDirtyInput();
        
        String resultInput = getInput();
        String sep = CalculatorUtils.getDecimalSeparator();
        
        // Evita colocar mais de um separador decimal
        if (input.equals(sep)) {
            if (resultInput.isEmpty()) {
                resultInput = "0";
            }
            if (resultInput.contains(sep)) {
                return;
            }
        }
        
        // Limita o número de casas decimais
        if (resultInput.contains(sep)) {
            int decimalDigits = resultInput.substring(resultInput.indexOf(sep) + 1).length();
            if (decimalDigits >= CalculatorUtils.getPrecision()) {
                return;
            }
        }
        
        resultInput += input;
        setInput(resultInput);
        
        setDirty(true);
    }
    
    public void handleOperationCommand(String operation) {
        String input = getInput();
        if (input.isEmpty()) {
            return;
        }
        
        if (this.error != null) {
            clearError();
            return;
        }
        
        if (operation == null && getOperator() == null && getLeftOperand() != null && getRightOperand() == null) {
            return;
        }
        
        // Se o operador for nulo (=), não houver operando da direita, e não houver input novo, define como se tivesse
        if (operation == null && !isDirty()) {
            if (getLeftOperand() != null && getRightOperand() == null) {
                setDirty(true);
            } else if (getLeftOperand() != null && isResultShown()) {
                clearLeftOperand();
                setDirty(true);
                
                // Planifica o valor do operando da direita, caso houver alguma
                // operação unária sendo exibida
                setRightOperand(getRightOperand().getValue());
            }
        }
        
        if (isDirty()) {
            // Operando da esquerda ainda não definido, define
            if (getLeftOperand() == null) {
                setLeftOperand(getInputValue());

            // Operando da direita ainda não definido, ou resultado não exibido, define
            // operando da direita
            } else if (getRightOperand() == null) {
                setRightOperand(getInputValue());
            }
        }
        
        if (operation == null) {
            setResultShown(true);
        }
        
        AbstractOperator newOperator = calculatorInstance.getOperator(operation);
        
        // Não execute o operador atual se um operador unário for selecionado
        if (newOperator == null || !newOperator.isUnaryOperator()) {
            executeBinaryOperator();
        }
        
        if (newOperator != null) {
            setOperator(newOperator);
        }
        
        setDirty(false);
    }
    
    public boolean executeBinaryOperator() {
        return executeOperator(getOperator());
    }
    
    public boolean executeOperator(AbstractOperator targetOperator) {
        try {
             // Executa a operação anterior
            if (targetOperator != null) {
                
                if (targetOperator.isUnaryOperator() || (getLeftOperand() != null && getRightOperand() != null)) {
                    targetOperator.operate();
                    return true;
                }
            }
        } catch (ArithmeticException ex) {
            setError(CalculatorUtils.getErrorMessage(ex));
        }
        return false;
    }
    
    public void setError(String error) {
        this.error = error;
        
        if (error == null) {
            clearState();
            setOperatorsEnabled(true);
        } else {
            setPlainInput(error);
            setOperatorsEnabled(false);
        }
    }
    
    public void clearError() {
        if (this.error != null) {
            setError(null);
        }
    }
    
    public void setOperatorsEnabled(boolean enabled) {
        for (JButton btn : calculatorInstance.getOperationButtons()) {
            btn.setEnabled(enabled);
        }
    }
    
    public void toggleInputSignal() {
        setInput(getInputValue().negate());
        setDirty(true);
    }
    
    public void showResult() {
        handleOperationCommand(null);
    }
}
