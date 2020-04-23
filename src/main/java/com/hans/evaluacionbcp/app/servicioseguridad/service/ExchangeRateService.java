package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.dao.ICurrencyDao;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Currency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Rates;
import com.hans.evaluacionbcp.app.servicioseguridad.model.request.RequestCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateService implements IExchangeRateService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateService.class);

    private final ICurrencyDao currencyDao;

    @Autowired
    public ExchangeRateService(ICurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public ResponseExchangeRate exchangeRateAmount(Double amount, String currencyOrigin, String currencyDestination) {
        log.info("exchangeRateAmount service");
        Currency currency = currencyDao.findByCurrencyBase(currencyOrigin);
        if (currency == null) {
            log.debug("Moneda de origen no encontrada");
            return null;
        }

        // get currency rate destination
        Rates currencyRateDestination = getCurrencyRateDestination(currency, currencyDestination);
        if (currencyRateDestination == null) {
            log.debug("Tipo de cambio destino no encontrado");
            return null;
        }

        ResponseExchangeRate exchangeRate = new ResponseExchangeRate();
        exchangeRate.setAmount(amount);
        exchangeRate.setCurrencyOrigin(currencyOrigin);
        exchangeRate.setCurrencyDestination(currencyDestination);
        exchangeRate.setExchangeRate(currencyRateDestination.getExchangeRate());
        exchangeRate.setExchangeRateAmount(calculateExchangeRateAmount(amount, currencyRateDestination.getExchangeRate()));
        return exchangeRate;
    }

    private Rates getCurrencyRateDestination(Currency currency, String currencyDestination) {
        return currency.getRates().stream()
                .filter(currencyRates -> currencyRates.getRate().equals(currencyDestination))
                .findAny()
                .orElse(null);
    }

    private Double calculateExchangeRateAmount(Double amount, Double exchangeRate) {
        double calculatedAmount = amount * exchangeRate;
        return new BigDecimal(calculatedAmount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public ResponseCurrency updateCurrency(RequestCurrency requestCurrency) {
       Currency currency  = currencyDao.findByCurrencyBase(requestCurrency.getCurrency());

       if (currency == null) {
           return null;
       }

        // get currency rate destination
        Rates currencyRateDestination = getCurrencyRateDestination(currency, requestCurrency.getCurrencyDestination());
        if (currencyRateDestination == null) {
            log.debug("Tipo de cambio destino no encontrado");
            return null;
        }




        return null;
    }
}
