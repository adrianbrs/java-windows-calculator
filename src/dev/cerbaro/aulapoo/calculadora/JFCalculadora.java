/*
 * To change this li            @Override
            public int getWidth(ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int getHeight(ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public ImageProducer getSource() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Graphics getGraphics() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }ense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.cerbaro.aulapoo.calculadora;

import dev.cerbaro.aulapoo.calculadora.operators.DivisionOperator;
import dev.cerbaro.aulapoo.calculadora.operators.MultiplicationOperator;
import dev.cerbaro.aulapoo.calculadora.operators.SubtractionOperator;
import dev.cerbaro.aulapoo.calculadora.operators.SumOperator;
import dev.cerbaro.aulapoo.calculadora.operators.unary.InverseOperator;
import dev.cerbaro.aulapoo.calculadora.operators.unary.PercentOperator;
import dev.cerbaro.aulapoo.calculadora.operators.unary.Pow2Operator;
import dev.cerbaro.aulapoo.calculadora.operators.unary.Sqrt2Operator;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author 178304
 */
public class JFCalculadora extends javax.swing.JFrame {
    private final Map<String, AbstractOperator> operatorMap = new HashMap();
    private CalculatorState state;

    /**
     * Creates new form jfCalculadora
     */
    public JFCalculadora() {
        initComponents();
        
        initButtonsReference();
        initState();
        
        // Key listener
        KeyboardFocusManager kbFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kbFocusManager.addKeyEventDispatcher(new CalculatorEventDispatcher(this));
        
        // Operadores disponíveis
        
        // Binários
        registerOperator(new SumOperator());
        registerOperator(new SubtractionOperator());
        registerOperator(new MultiplicationOperator());
        registerOperator(new DivisionOperator());
        
        // Unários
        registerOperator(new InverseOperator());
        registerOperator(new Pow2Operator());
        registerOperator(new PercentOperator());
        registerOperator(new Sqrt2Operator());
    }
    
    private void registerOperator(AbstractOperator operator) {
        operator.setState(state);
        this.operatorMap.put(operator.getOperationCode(), operator);
    }
    
    public AbstractOperator getOperator(String op) {
        if (op == null) {
            return null;
        }
        AbstractOperator operator = this.operatorMap.get(op);
        if (operator == null) {
            throw new IllegalArgumentException("Operator \"" + op + "\" not found.");
        }
        return operator;
    }
    
    private void initButtonsReference() {
        operationButtons = new JButton[]{
            jButtonSum, jButtonSubtract, jButtonMultiply, jButtonDiv,
            jButtonToggleSignal, jButtonErase,
            jButtonPercentOp, jButtonInverseOp, jButtonPow2Op, jButtonSqrt2Op
        };
        
        numberButtons = new JButton[]{
            jButtonNum0, jButtonNum1, jButtonNum2, jButtonNum3,
            jButtonNum4, jButtonNum5, jButtonNum6, jButtonNum7,
            jButtonNum8, jButtonNum9, jButtonDecimalSeparator
        };
        
        availableButtons = new ArrayList();
        for (Component comp : jPanelButtons.getComponents()) {
            if (comp instanceof JButton) {
                availableButtons.add((JButton) comp);
            }
        }
    }
    
    private void initState() {
        this.state = new CalculatorState(this);
    }
    
    public CalculatorState getCalculatorState() {
        return state;
    }
    
    public JButton[] getOperationButtons() {
        return operationButtons;
    }
    
    public JButton[] getNumberButtons() {
        return numberButtons;
    }
    
    public List<JButton> getAvailableButtons() {
        return availableButtons;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setBounds(new java.awt.Rectangle(0, 0, 320, 400));
        setForeground(new java.awt.Color(17, 17, 17));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/calculator-icon.png")).getImage());
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(320, 440));
        setPreferredSize(new java.awt.Dimension(320, 420));
        setSize(new java.awt.Dimension(320, 420));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelContainer.setMaximumSize(new java.awt.Dimension(750, 600));
        jPanelContainer.setMinimumSize(new java.awt.Dimension(320, 420));
        jPanelContainer.setPreferredSize(new java.awt.Dimension(750, 600));
        jPanelContainer.setLayout(new java.awt.BorderLayout());

        jPanelVisor.setBackground(new java.awt.Color(235, 235, 235));
        jPanelVisor.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 16, 12));
        jPanelVisor.setForeground(new java.awt.Color(254, 254, 254));
        jPanelVisor.setMaximumSize(new java.awt.Dimension(400, 90));
        jPanelVisor.setMinimumSize(new java.awt.Dimension(412, 90));
        jPanelVisor.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanelVisor.setLayout(new java.awt.BorderLayout(0, 6));

        jLabelOperations.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        jLabelOperations.setForeground(new java.awt.Color(85, 85, 85));
        jLabelOperations.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelOperations.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelOperations.setMaximumSize(new java.awt.Dimension(400, 24));
        jLabelOperations.setMinimumSize(new java.awt.Dimension(400, 24));
        jLabelOperations.setPreferredSize(new java.awt.Dimension(400, 24));
        jPanelVisor.add(jLabelOperations, java.awt.BorderLayout.NORTH);

        jLabelInput.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabelInput.setForeground(new java.awt.Color(17, 17, 17));
        jLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelInput.setMaximumSize(new java.awt.Dimension(400, 40));
        jLabelInput.setMinimumSize(new java.awt.Dimension(400, 40));
        jLabelInput.setPreferredSize(new java.awt.Dimension(400, 40));
        jLabelInput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelInputPropertyChange(evt);
            }
        });
        jPanelVisor.add(jLabelInput, java.awt.BorderLayout.SOUTH);

        jPanelContainer.add(jPanelVisor, java.awt.BorderLayout.NORTH);

        jPanelButtons.setBackground(new java.awt.Color(235, 235, 235));
        jPanelButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanelButtons.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanelButtons.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanelButtons.setLayout(new java.awt.GridLayout(6, 4, 2, 2));

        jButtonPercentOp.setBackground(new java.awt.Color(244, 244, 244));
        jButtonPercentOp.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonPercentOp.setForeground(new java.awt.Color(17, 17, 17));
        jButtonPercentOp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/percent-outline.png"))); // NOI18N
        jButtonPercentOp.setActionCommand("%");
        jButtonPercentOp.setBorderPainted(false);
        jButtonPercentOp.setFocusPainted(false);
        jButtonPercentOp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPercentOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPercentOpActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonPercentOp);

        jButtonClearInput.setBackground(new java.awt.Color(244, 244, 244));
        jButtonClearInput.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonClearInput.setForeground(new java.awt.Color(17, 17, 17));
        jButtonClearInput.setText("CE");
        jButtonClearInput.setBorderPainted(false);
        jButtonClearInput.setFocusPainted(false);
        jButtonClearInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClearInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearInputActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonClearInput);

        jButtonClear.setBackground(new java.awt.Color(244, 244, 244));
        jButtonClear.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonClear.setForeground(new java.awt.Color(17, 17, 17));
        jButtonClear.setText("C");
        jButtonClear.setBorderPainted(false);
        jButtonClear.setFocusPainted(false);
        jButtonClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonClear);

        jButtonErase.setBackground(new java.awt.Color(244, 244, 244));
        jButtonErase.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonErase.setForeground(new java.awt.Color(17, 17, 17));
        jButtonErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/backspace-outline.png"))); // NOI18N
        jButtonErase.setBorderPainted(false);
        jButtonErase.setFocusPainted(false);
        jButtonErase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEraseActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonErase);

        jButtonInverseOp.setBackground(new java.awt.Color(244, 244, 244));
        jButtonInverseOp.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonInverseOp.setForeground(new java.awt.Color(17, 17, 17));
        jButtonInverseOp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/vulgar-fraction.png"))); // NOI18N
        jButtonInverseOp.setActionCommand("1/x");
        jButtonInverseOp.setBorderPainted(false);
        jButtonInverseOp.setFocusPainted(false);
        jButtonInverseOp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonInverseOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInverseOpActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonInverseOp);

        jButtonPow2Op.setBackground(new java.awt.Color(244, 244, 244));
        jButtonPow2Op.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonPow2Op.setForeground(new java.awt.Color(17, 17, 17));
        jButtonPow2Op.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/power-2.png"))); // NOI18N
        jButtonPow2Op.setActionCommand("x^2");
        jButtonPow2Op.setBorderPainted(false);
        jButtonPow2Op.setFocusPainted(false);
        jButtonPow2Op.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPow2Op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPow2OpActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonPow2Op);

        jButtonSqrt2Op.setBackground(new java.awt.Color(244, 244, 244));
        jButtonSqrt2Op.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonSqrt2Op.setForeground(new java.awt.Color(17, 17, 17));
        jButtonSqrt2Op.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/square-root.png"))); // NOI18N
        jButtonSqrt2Op.setActionCommand("sqrt2");
        jButtonSqrt2Op.setBorderPainted(false);
        jButtonSqrt2Op.setFocusPainted(false);
        jButtonSqrt2Op.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSqrt2Op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSqrt2OpActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonSqrt2Op);

        jButtonDiv.setBackground(new java.awt.Color(244, 244, 244));
        jButtonDiv.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonDiv.setForeground(new java.awt.Color(17, 17, 17));
        jButtonDiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/division.png"))); // NOI18N
        jButtonDiv.setActionCommand("/");
        jButtonDiv.setBorderPainted(false);
        jButtonDiv.setFocusPainted(false);
        jButtonDiv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDivActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonDiv);

        jButtonNum7.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum7.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum7.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum7.setText("7");
        jButtonNum7.setBorderPainted(false);
        jButtonNum7.setFocusPainted(false);
        jButtonNum7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum7ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum7);

        jButtonNum8.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum8.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum8.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum8.setText("8");
        jButtonNum8.setBorderPainted(false);
        jButtonNum8.setFocusPainted(false);
        jButtonNum8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum8ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum8);

        jButtonNum9.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum9.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum9.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum9.setText("9");
        jButtonNum9.setBorderPainted(false);
        jButtonNum9.setFocusPainted(false);
        jButtonNum9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum9ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum9);

        jButtonMultiply.setBackground(new java.awt.Color(244, 244, 244));
        jButtonMultiply.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonMultiply.setForeground(new java.awt.Color(17, 17, 17));
        jButtonMultiply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/multiply.png"))); // NOI18N
        jButtonMultiply.setActionCommand("*");
        jButtonMultiply.setBorderPainted(false);
        jButtonMultiply.setFocusPainted(false);
        jButtonMultiply.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplyActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonMultiply);

        jButtonNum4.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum4.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum4.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum4.setText("4");
        jButtonNum4.setBorderPainted(false);
        jButtonNum4.setFocusPainted(false);
        jButtonNum4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum4ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum4);

        jButtonNum5.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum5.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum5.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum5.setText("5");
        jButtonNum5.setBorderPainted(false);
        jButtonNum5.setFocusPainted(false);
        jButtonNum5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum5ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum5);

        jButtonNum6.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum6.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum6.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum6.setText("6");
        jButtonNum6.setBorderPainted(false);
        jButtonNum6.setFocusPainted(false);
        jButtonNum6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum6ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum6);

        jButtonSubtract.setBackground(new java.awt.Color(244, 244, 244));
        jButtonSubtract.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonSubtract.setForeground(new java.awt.Color(17, 17, 17));
        jButtonSubtract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/minus.png"))); // NOI18N
        jButtonSubtract.setActionCommand("-");
        jButtonSubtract.setBorderPainted(false);
        jButtonSubtract.setFocusPainted(false);
        jButtonSubtract.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubtractActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonSubtract);

        jButtonNum1.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum1.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum1.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum1.setText("1");
        jButtonNum1.setBorderPainted(false);
        jButtonNum1.setFocusPainted(false);
        jButtonNum1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum1ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum1);

        jButtonNum2.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum2.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum2.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum2.setText("2");
        jButtonNum2.setBorderPainted(false);
        jButtonNum2.setFocusPainted(false);
        jButtonNum2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum2ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum2);

        jButtonNum3.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum3.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum3.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum3.setText("3");
        jButtonNum3.setBorderPainted(false);
        jButtonNum3.setFocusPainted(false);
        jButtonNum3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum3ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum3);

        jButtonSum.setBackground(new java.awt.Color(244, 244, 244));
        jButtonSum.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonSum.setForeground(new java.awt.Color(17, 17, 17));
        jButtonSum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/plus.png"))); // NOI18N
        jButtonSum.setActionCommand("+");
        jButtonSum.setBorderPainted(false);
        jButtonSum.setFocusPainted(false);
        jButtonSum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSumActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonSum);

        jButtonToggleSignal.setBackground(new java.awt.Color(251, 251, 251));
        jButtonToggleSignal.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonToggleSignal.setForeground(new java.awt.Color(17, 17, 17));
        jButtonToggleSignal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/plus-minus.png"))); // NOI18N
        jButtonToggleSignal.setActionCommand("+/-");
        jButtonToggleSignal.setBorderPainted(false);
        jButtonToggleSignal.setFocusPainted(false);
        jButtonToggleSignal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonToggleSignal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToggleSignalActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonToggleSignal);

        jButtonNum0.setBackground(new java.awt.Color(251, 251, 251));
        jButtonNum0.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonNum0.setForeground(new java.awt.Color(17, 17, 17));
        jButtonNum0.setText("0");
        jButtonNum0.setBorderPainted(false);
        jButtonNum0.setFocusPainted(false);
        jButtonNum0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum0ActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonNum0);

        jButtonDecimalSeparator.setBackground(new java.awt.Color(251, 251, 251));
        jButtonDecimalSeparator.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jButtonDecimalSeparator.setForeground(new java.awt.Color(17, 17, 17));
        jButtonDecimalSeparator.setText(".");
        jButtonDecimalSeparator.setBorderPainted(false);
        jButtonDecimalSeparator.setFocusPainted(false);
        jButtonDecimalSeparator.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDecimalSeparator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecimalSeparatorActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonDecimalSeparator);
        String sep = CalculatorUtils.getDecimalSeparator();
        jButtonDecimalSeparator.setText(sep);
        jButtonDecimalSeparator.setActionCommand(sep);

        jButtonEquals.setBackground(new java.awt.Color(244, 244, 244));
        jButtonEquals.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jButtonEquals.setForeground(new java.awt.Color(17, 17, 17));
        jButtonEquals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/cerbaro/aulapoo/calculadora/icons/equal.png"))); // NOI18N
        jButtonEquals.setActionCommand("=");
        jButtonEquals.setBorderPainted(false);
        jButtonEquals.setFocusPainted(false);
        jButtonEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEqualsActionPerformed(evt);
            }
        });
        jPanelButtons.add(jButtonEquals);

        jPanelContainer.add(jPanelButtons, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelContainer, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNum7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum7ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum7ActionPerformed

    private void jButtonNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum1ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum1ActionPerformed

    private void jButtonNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum2ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum2ActionPerformed

    private void jButtonNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum3ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum3ActionPerformed

    private void jButtonNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum4ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum4ActionPerformed

    private void jButtonNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum5ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum5ActionPerformed

    private void jButtonNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum6ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum6ActionPerformed

    private void jButtonNum8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum8ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum8ActionPerformed

    private void jButtonNum9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum9ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum9ActionPerformed

    private void jButtonSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSumActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonSumActionPerformed

    private void jButtonSubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubtractActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonSubtractActionPerformed

    private void jButtonMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplyActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonMultiplyActionPerformed

    private void jButtonDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonDivActionPerformed

    private void jButtonDecimalSeparatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecimalSeparatorActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonDecimalSeparatorActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        state.clearState();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonNum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum0ActionPerformed
        state.handleInputCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonNum0ActionPerformed

    private void jButtonEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEqualsActionPerformed
        state.showResult();
    }//GEN-LAST:event_jButtonEqualsActionPerformed

    private void jButtonClearInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearInputActionPerformed
        state.clearInputOrState();
    }//GEN-LAST:event_jButtonClearInputActionPerformed

    private void jButtonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEraseActionPerformed
        state.eraseInput();
    }//GEN-LAST:event_jButtonEraseActionPerformed

    private void jButtonToggleSignalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToggleSignalActionPerformed
        state.toggleInputSignal();
    }//GEN-LAST:event_jButtonToggleSignalActionPerformed

    private void jLabelInputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelInputPropertyChange
        // Sempre que o texto for alterado, ajusta o label para que o texto encaixe no componente
        if (evt.getPropertyName().equalsIgnoreCase("text")) {
            CalculatorUtils.autosizeLabel((JLabel) evt.getSource());
        }
    }//GEN-LAST:event_jLabelInputPropertyChange

    private void jButtonInverseOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInverseOpActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonInverseOpActionPerformed

    private void jButtonPow2OpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPow2OpActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonPow2OpActionPerformed

    private void jButtonSqrt2OpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSqrt2OpActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonSqrt2OpActionPerformed

    private void jButtonPercentOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPercentOpActionPerformed
        state.handleOperationCommand(evt.getActionCommand());
    }//GEN-LAST:event_jButtonPercentOpActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        CalculatorUtils.autosizeLabel(jLabelInput);
    }//GEN-LAST:event_formComponentResized

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCalculadora().setVisible(true);
            }
        });
    }
    
    private JButton[] operationButtons;
    private JButton[] numberButtons;
    private List<JButton> availableButtons;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public final javax.swing.JButton jButtonClear = new javax.swing.JButton();
    public final javax.swing.JButton jButtonClearInput = new javax.swing.JButton();
    public final javax.swing.JButton jButtonDecimalSeparator = new javax.swing.JButton();
    public final javax.swing.JButton jButtonDiv = new javax.swing.JButton();
    public final javax.swing.JButton jButtonEquals = new javax.swing.JButton();
    public final javax.swing.JButton jButtonErase = new javax.swing.JButton();
    public final javax.swing.JButton jButtonInverseOp = new javax.swing.JButton();
    public final javax.swing.JButton jButtonMultiply = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum0 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum1 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum2 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum3 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum4 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum5 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum6 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum7 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum8 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonNum9 = new javax.swing.JButton();
    public final javax.swing.JButton jButtonPercentOp = new javax.swing.JButton();
    public final javax.swing.JButton jButtonPow2Op = new javax.swing.JButton();
    public final javax.swing.JButton jButtonSqrt2Op = new javax.swing.JButton();
    public final javax.swing.JButton jButtonSubtract = new javax.swing.JButton();
    public final javax.swing.JButton jButtonSum = new javax.swing.JButton();
    public final javax.swing.JButton jButtonToggleSignal = new javax.swing.JButton();
    public final javax.swing.JLabel jLabelInput = new javax.swing.JLabel();
    public final javax.swing.JLabel jLabelOperations = new javax.swing.JLabel();
    public final javax.swing.JPanel jPanelButtons = new javax.swing.JPanel();
    public final javax.swing.JPanel jPanelContainer = new javax.swing.JPanel();
    public final javax.swing.JPanel jPanelVisor = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables
}
