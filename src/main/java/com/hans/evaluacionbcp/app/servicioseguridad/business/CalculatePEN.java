package com.hans.evaluacionbcp.app.servicioseguridad.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatePEN implements Calculate {

    @Override
    public String calculateAmount(Double amount, Double currencyChange) {
        double calculate= amount*currencyChange;
        BigDecimal bd = new BigDecimal(calculate);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }
}
