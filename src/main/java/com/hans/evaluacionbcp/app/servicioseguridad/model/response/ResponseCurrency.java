package com.hans.evaluacionbcp.app.servicioseguridad.model.response;

public class ResponseCurrency {
    private String currency;
    private Double exchangeRate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
