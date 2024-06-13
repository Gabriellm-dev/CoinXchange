package br.com.coinXchange.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/f66ad026d5fe76ad3bb97f3f/latest/";

    public JsonObject getExchangeRates(String baseCurrency) throws IOException {
        String urlStr = API_URL + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonObject();
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) throws IOException {
        JsonObject exchangeRates = getExchangeRates(fromCurrency);
        JsonObject conversionRates = exchangeRates.getAsJsonObject("conversion_rates");
        double fromRate = conversionRates.get(fromCurrency).getAsDouble();
        double toRate = conversionRates.get(toCurrency).getAsDouble();

        return amount * (toRate / fromRate);
    }
}
