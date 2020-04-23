package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.model.request.RequestCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseCurrency;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseExchangeRate;

public interface IExchangeRateService {

    ResponseExchangeRate exchangeRateAmount(Double amount, String currencyOrigin, String currencyDestination);

    ResponseCurrency updateCurrency(RequestCurrency currency);
}
