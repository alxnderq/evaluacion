package com.hans.evaluacionbcp.app.servicioseguridad.business;

public class CalculateFactory {

    public Calculate getCalculate(String currency) {
        if (currency == null) {
            return null;
        }
        if (currency.equalsIgnoreCase("PEN")) {
            return new CalculatePEN();
        } else if (currency.equalsIgnoreCase("USD")) {
            return new CalculateUSD();
        }
        return null;
    }
}

