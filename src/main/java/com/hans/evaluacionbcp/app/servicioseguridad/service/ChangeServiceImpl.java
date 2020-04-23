package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.business.CalculateFactory;
import com.hans.evaluacionbcp.app.servicioseguridad.dao.IChangeDao;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Change;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangeServiceImpl implements IChangeService {
    private static Logger log = LoggerFactory.getLogger(ChangeServiceImpl.class);

    @Autowired
    private IChangeDao changeDao;

    @Override
    @Transactional(readOnly = true)
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

    private String calculateChangeAmount(Double amount, Double currencyType, String currency) {
        CalculateFactory calculateFactory = new CalculateFactory();
        String cal = calculateFactory.getCalculate(currency).calculateAmount(amount, currencyType);
        log.info(String.format("Calculo factory %s", cal));
        return cal;
    }


    @Override
    @Transactional
    public Change updareChangeMoney(Change change) {
        Change changeResponse = changeDao.findByDescripcion(change.getDescripcion());
        if (changeResponse == null) {
            return null;
        }
        changeResponse.setTipoCambio(change.getTipoCambio());
        return changeDao.save(changeResponse);
    }
}
