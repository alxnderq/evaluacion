package com.hans.evaluacionbcp.app.servicioseguridad.model.response;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class ResponseChange implements Serializable {

    private Double amount;
    private String currencyOrigin;
    private String currencyDestination;
    private String amountChange;
    private Double changeType;

    @JsonProperty("monto")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("monedaOrigen")
    public String getCurrencyOrigin() {
        return currencyOrigin;
    }

    public void setCurrencyOrigin(String currencyOrigin) {
        this.currencyOrigin = currencyOrigin;
    }
    @JsonProperty("monedaDestino")
    public String getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(String currencyDestination) {
        this.currencyDestination = currencyDestination;
    }

    public String getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(String amountChange) {
        this.amountChange = amountChange;
    }

    public Double getChangeType() {
        return changeType;
    }

    public void setChangeType(Double changeType) {
        this.changeType = changeType;
    }
}
