package com.hans.evaluacionbcp.app.servicioseguridad.model.request;

import java.io.Serializable;

public class RequestCurrency implements Serializable {
    private String currency;
    private String currencyDestination;
    private Double amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(String currencyDestination) {
        this.currencyDestination = currencyDestination;
    }
}
