package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.dao.IChangeDao;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Change;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ChangeServiceImpl implements IChangeService {
    private static Logger log = LoggerFactory.getLogger(ChangeServiceImpl.class);

    @Autowired
    private IChangeDao changeDao;

    @Override
    public ResponseChange changeCurrency(Double amount, String currencyOrigin, String currencyDestination) {
        log.info("changeCurrency Service");
        Change change = changeDao.findByDescripcion(currencyDestination);
        if (change == null) {
            log.debug("Tipo de cambio destino no encontrado");
            return null;
        }

        ResponseChange responseChange = new ResponseChange();
        responseChange.setAmount(amount);
        responseChange.setChangeType(Double.parseDouble(change.getTipoCambio()));
        responseChange.setCurrencyOrigin(currencyOrigin);
        responseChange.setCurrencyDestination(currencyDestination);
        responseChange.setAmountChange(
                calculateChangeAmount(amount, Double.parseDouble(change.getTipoCambio()), currencyDestination));
        return responseChange;
    }

    private Double calculateChangeAmount(Double amount, Double currencyType, String currency) {
        double calculate = 0.0;
        switch (currency) {
            case "USD":
                calculate = amount * currencyType;
                break;
            case "PEN":
                calculate = amount / currencyType;
                break;
        }
        log.debug(String.format("Calculo de monto %s", calculate));
        BigDecimal bd = new BigDecimal(calculate);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
