package br.com.coinXchange.model;

public class ConversionRate {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double rate;

    // Construtor
    public ConversionRate(String fromCurrencyCode, String toCurrencyCode, double rate) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.rate = rate;
    }

    // Métodos getters e setters
    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    // Método toString para representação textual da taxa de conversão
    @Override
    public String toString() {
        return "ConversionRate{" +
                "fromCurrencyCode='" + fromCurrencyCode + '\'' +
                ", toCurrencyCode='" + toCurrencyCode + '\'' +
                ", rate=" + rate +
                '}';
    }
}
