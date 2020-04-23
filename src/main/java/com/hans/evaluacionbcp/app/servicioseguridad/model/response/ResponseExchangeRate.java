package com.hans.evaluacionbcp.app.servicioseguridad.model.response;

import java.io.Serializable;

public class ResponseExchangeRate implements Serializable {

    private Double amount;
    private Double exchangeRateAmount;
    private String currencyOrigin;
    private String currencyDestination;
    private Double exchangeRate;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getExchangeRateAmount() {
        return exchangeRateAmount;
    }

    public void setExchangeRateAmount(Double exchangeRateAmount) {
        this.exchangeRateAmount = exchangeRateAmount;
    }

    public String getCurrencyOrigin() {
        return currencyOrigin;
    }

    public void setCurrencyOrigin(String currencyOrigin) {
        this.currencyOrigin = currencyOrigin;
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
