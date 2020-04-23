package com.hans.evaluacionbcp.app.servicioseguridad.controller;

import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseExchangeRate;
import com.hans.evaluacionbcp.app.servicioseguridad.service.IExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateController.class);

    private final IExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(IExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/exchange")
    public ResponseEntity<?> exchangeCurrency(@RequestParam Double amount, @RequestParam String currencyOrigin,
                                              @RequestParam String currencyDestination) {
        log.info("ChangeMoney Controller");
        ResponseExchangeRate response = exchangeRateService.exchangeRateAmount(amount, currencyOrigin, currencyDestination);
        if (response == null) {
            String msj = "Tipo de cambio seleccionado invalido.";
            return new ResponseEntity<>(msj, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
