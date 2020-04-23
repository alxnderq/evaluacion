package com.hans.evaluacionbcp.app.servicioseguridad.controller;

import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseChange;
import com.hans.evaluacionbcp.app.servicioseguridad.service.IChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeCurrencyController {

    private static Logger log = LoggerFactory.getLogger(ChangeCurrencyController.class);

    @Autowired
    private IChangeService changeService;

    @GetMapping("/changeMoney")
        public ResponseEntity<?> consultChangeCurrency(@RequestParam Double amount, @RequestParam String currencyOrigin,
                                                   @RequestParam String currencyDestination) {
        log.info("ChangeMoney Controller");
        ResponseChange responseChange = changeService.changeCurrency(amount, currencyOrigin, currencyDestination);
        if (responseChange == null) {
            String msj = "Tipo de cambio seleccionado invalido.";
            return new ResponseEntity<String>(msj, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ResponseChange>(responseChange, HttpStatus.OK);
    }
}
