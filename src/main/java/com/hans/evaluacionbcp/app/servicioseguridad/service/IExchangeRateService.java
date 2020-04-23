package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseExchangeRate;

public interface IExchangeRateService {

    ResponseExchangeRate exchangeRateAmount(Double amount, String currencyOrigin, String currencyDestination);
}
