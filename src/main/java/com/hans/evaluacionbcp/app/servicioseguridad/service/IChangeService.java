package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseChange;

public interface IChangeService {


    ResponseChange changeCurrency(Double amount, String currencyOrigin, String currencyDestination);

}
