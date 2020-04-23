package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.dao.ICurrencyDao;
import com.hans.evaluacionbcp.app.servicioseguridad.dao.IRatesDao;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Currency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.Rates;
import com.hans.evaluacionbcp.app.servicioseguridad.model.request.RequestCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateService implements IExchangeRateService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateService.class);

    private final ICurrencyDao currencyDao;
    private final IRatesDao ratesDao;

    @Autowired
    public ExchangeRateService(ICurrencyDao currencyDao, IRatesDao ratesDao) {
        this.currencyDao = currencyDao;
        this.ratesDao = ratesDao;
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional
    public ResponseCurrency updateCurrency(RequestCurrency requestCurrency) {
        Rates rate = ratesDao.findByCurrency(requestCurrency.getCurrency(), requestCurrency.getCurrencyDestination());

        if (rate == null) {
            log.debug("Tipo de cambio destino no encontrado");
            return null;
        }

        rate.setExchangeRate(requestCurrency.getExchangeRate());
        ratesDao.save(rate);

        ResponseCurrency response = new ResponseCurrency();
        response.setCurrency(requestCurrency.getCurrency());
        response.setExchangeRate(requestCurrency.getExchangeRate());

        return response;
    }
}
