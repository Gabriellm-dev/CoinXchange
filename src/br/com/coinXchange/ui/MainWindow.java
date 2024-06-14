package br.com.coinXchange.ui;

import javax.swing.*;
import java.awt.*;

import br.com.coinXchange.api.CurrencyConverter;


public class MainWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Criar uma instância de CurrencyConverter
            CurrencyConverter currencyConverter = new CurrencyConverter();

            // Criar a janela principal
            JFrame frame = new JFrame("Currency Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Criar um CurrencyConverterPanel e passar a instância de CurrencyConverter
            CurrencyConverterPanel converterPanel = new CurrencyConverterPanel(currencyConverter);
            frame.add(converterPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
