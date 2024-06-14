package br.com.coinXchange.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import br.com.coinXchange.api.CurrencyConverter;

public class CurrencyConverterPanel extends JPanel {
    private CurrencyConverter currencyConverter;
    private JTextField textFieldAmount;
    private JComboBox<String> comboBoxFromCurrency;
    private JComboBox<String> comboBoxToCurrency;
    private JButton buttonConvert;
    private JLabel labelResult;

    public CurrencyConverterPanel(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;

        setLayout(new GridLayout(5, 1));

        // Componentes da interface do usuário
        JLabel labelFromCurrency = new JLabel("From Currency:");
        add(labelFromCurrency);

        comboBoxFromCurrency = new JComboBox<>(new String[]{"BRL", "USD", "CNY", "EUR", "JPY", "GBP", "CHF", "CAD"}); // Adicione mais moedas conforme necessário
        add(comboBoxFromCurrency);

        JLabel labelToCurrency = new JLabel("To Currency:");
        add(labelToCurrency);

        comboBoxToCurrency = new JComboBox<>(new String[]{"BRL", "USD", "CNY", "EUR", "JPY", "GBP", "CHF", "CAD"}); // Adicione mais moedas conforme necessário
        add(comboBoxToCurrency);

        textFieldAmount = new JTextField();
        add(textFieldAmount);

        buttonConvert = new JButton("Convert");
        buttonConvert.addActionListener(e -> {
            // Obter os valores selecionados nos JComboBoxes
            String fromCurrency = (String) comboBoxFromCurrency.getSelectedItem();
            String toCurrency = (String) comboBoxToCurrency.getSelectedItem();
            double amount = Double.parseDouble(textFieldAmount.getText());

            // Chamar o método de conversão na classe CurrencyConverter
            try {
                double convertedAmount = currencyConverter.convertCurrency(amount, fromCurrency, toCurrency);
                labelResult.setText("Result: " + convertedAmount);
            } catch (IOException ex) {
                ex.printStackTrace();
                labelResult.setText("Error: Unable to convert");
            }
        });
        add(buttonConvert);

        labelResult = new JLabel("Result:");
        add(labelResult);
    }
}
