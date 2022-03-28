/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author adrian
 */
public class CalculatorEventDispatcher implements KeyEventDispatcher {
    private final JFCalculadora calcInstance;
    
    public CalculatorEventDispatcher(JFCalculadora calcInstance) {
        this.calcInstance = calcInstance;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            keyPressed(e);
        }
        return false;
    }
    
    private void keyPressed(KeyEvent e) {
        String keyStr = String.valueOf(e.getKeyChar());
        CalculatorState state = calcInstance.getCalculatorState();
        int keyCode = e.getKeyCode();
        
        // https://support.microsoft.com/en-us/windows/keyboard-shortcuts-in-apps-139014e7-177b-d1f3-eb2e-7298b2599a34#bkmk_cal
        switch (keyCode) {
            // Apagar
            case KeyEvent.VK_BACK_SPACE:
                if (calcInstance.jButtonErase.isEnabled()) {
                    state.eraseInput();
                    e.consume();
                }
                break;
                
            // CE
            case KeyEvent.VK_DELETE:
                if (calcInstance.jButtonClearInput.isEnabled()) {
                    state.clearInputOrState();
                    e.consume();
                }
                break;
                
            // C
            case KeyEvent.VK_ESCAPE:
                if (calcInstance.jButtonClear.isEnabled()) {
                    state.clearState();
                    e.consume();
                }
                break;
                
            // =
            case KeyEvent.VK_EQUALS:
                if (!e.isShiftDown()) {
                    if (calcInstance.jButtonEquals.isEnabled()) {
                        state.showResult();
                        e.consume();
                    }
                }
                break;
            
            // = (enter)
            case KeyEvent.VK_ENTER:
                if (calcInstance.jButtonEquals.isEnabled()) {
                    state.showResult();
                    e.consume();
                }
                break;
                
            // +/-
            case KeyEvent.VK_F9:
                if (calcInstance.jButtonToggleSignal.isEnabled()) {
                    state.toggleInputSignal();
                    e.consume();
                }
                break;
                
            // 1/x
            case KeyEvent.VK_R:
                if (calcInstance.jButtonInverseOp.isEnabled()) {
                    state.handleOperationCommand("1/x");
                    e.consume();
                }
                break;
                
            // sqrt2(x)
            case KeyEvent.VK_2:
                // @
                if (e.isShiftDown()) {
                    if (calcInstance.jButtonSqrt2Op.isEnabled()) {
                        state.handleOperationCommand("sqrt2");
                        e.consume();
                    }
                }
                break;
                
                
            // %
            case KeyEvent.VK_5:
                // %
                if (e.isShiftDown()) {
                    if (calcInstance.jButtonPercentOp.isEnabled()) {
                        state.handleOperationCommand("%");
                        e.consume();
                    }
                }
                break;
                
            // x^2
            case KeyEvent.VK_Q:
                if (calcInstance.jButtonPow2Op.isEnabled()) {
                    state.handleOperationCommand("x^2");
                    e.consume();
                }
                break;
        }
        
        if (!e.isConsumed()) {
            for (JButton btn : calcInstance.getNumberButtons()) {
                if (btn.getActionCommand().equalsIgnoreCase(keyStr) && btn.isEnabled()) {
                    calcInstance.getCalculatorState().handleInputCommand(keyStr);
                    e.consume();
                    break;
                }
            }
        }
        
        if (!e.isConsumed()) {
            for (JButton btn : calcInstance.getOperationButtons()) {
                if (btn.getActionCommand().equalsIgnoreCase(keyStr) && btn.isEnabled()) {
                    calcInstance.getCalculatorState().handleOperationCommand(keyStr);
                    break;
                }
            }
        }
    }
}
