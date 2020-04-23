package com.hans.evaluacionbcp.app.servicioseguridad.model.request;

import java.io.Serializable;

public class RequestCurrency implements Serializable {
    private String currency;
    private String currencyDestination;
    private Double exchangeRate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(String currencyDestination) {
        this.currencyDestination = currencyDestination;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
