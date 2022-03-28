/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author adrian
 */
public class AutosizeDocumentListener implements DocumentListener {
    private JTextComponent textComponent;
    
    public AutosizeDocumentListener(JTextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        CalculatorUtils.autosizeTextComponent(textComponent);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {}

    @Override
    public void changedUpdate(DocumentEvent e) {
        CalculatorUtils.autosizeTextComponent(textComponent);
    }
    
    
}
