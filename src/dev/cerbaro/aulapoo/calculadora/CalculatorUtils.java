/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.cerbaro.aulapoo.calculadora;

import java.awt.Font;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.JLabel;

/**
 *
 * @author 178304
 */
public class CalculatorUtils {
    /**
     * Proporção mínima do texto, diminui no máximo até a escala definida
     */
    private static final double MIN_FONT_SCALE_RATIO = 0.4;
    
    /**
     * Converte um BigDecimal para uma string formatada
     * @param number
     * @return 
     */
    public static String numberToString(BigDecimal number) {
        // 34 casas decimais, máximo suportado pelo padrão IEEE 754R Decimal128
        DecimalFormat df = new DecimalFormat("###,###." + "#".repeat(getPrecision()));
        return df.format(number);
    }
    
    /**
     * Converte uma string formatada para um BigDecimal
     * @param text
     * @return 
     */
    public static BigDecimal stringToNumber(String text) {
        String sep = getDecimalSeparator();
        return new BigDecimal(text.replaceAll("[\\D](?<![\\" + sep + "\\-])", "").replace(sep, "."));
    }
    
    /**
     * @return Separador decimal padrão do sistema
     */
    public static String getDecimalSeparator() {
        return String.valueOf(((DecimalFormat) DecimalFormat.getInstance()).getDecimalFormatSymbols().getDecimalSeparator());
    }
    
    /**
     * Ajusta a fonte de um JLabel para que o texto não ultrapasse a largura do componente
     * @param label 
     */
    public static void autosizeLabel(JLabel label) {
        String text = label.getText();
        Font originalFont = (Font) label.getClientProperty("originalfont");
        
        // Salva as informações da fonte original se ainda não tiver sido salva
        if (originalFont == null) {
            originalFont = label.getFont();
            label.putClientProperty("originalfont", originalFont);
        }

        // Pega a largura do texto com a fonte original
        int stringWidth = label.getFontMetrics(originalFont).stringWidth(text);
        
        // Pega a largura real do componente
        int componentWidth = label.getWidth();

        // Se a largura do texto, for maior que do componente, altera o tamanho da fonte
        if (stringWidth > componentWidth) {
            // Pega a proporção da largura do texto para a largura do componente
            double widthRatio = Math.max((double) componentWidth / (double) stringWidth, MIN_FONT_SCALE_RATIO);
            
            // Escolona a fonte atual baseado na proporção calculada, para que ela encaixe dentro do componente
            // sem precisar ser truncada
            int newFontSize = (int) Math.floor(originalFont.getSize() * widthRatio);
            
            // Define o tamanho da fonte para o tamanho calculado
            label.setFont(new Font(originalFont.getName(), originalFont.getStyle(), newFontSize));
        } else {
            // A largura do texto cabe na largura do componente, então mantém a fonte original
            label.setFont(originalFont);
        }
    }
    
    public static String getErrorMessage(ArithmeticException ex) {
        String msg = ex.getMessage().toLowerCase();
        if (msg.contains("division by zero")) {
            return "Não é possível dividir por 0";
        }
        if (msg.contains("undefined")) {
            return "Resultado indefinido";
        }
        ex.printStackTrace();
        return "Erro aritmético desconhecido";
    }
    
    public static int getPrecision() {
        return AbstractOperator.MATH_CONTEXT.getPrecision() ;
    }
}
