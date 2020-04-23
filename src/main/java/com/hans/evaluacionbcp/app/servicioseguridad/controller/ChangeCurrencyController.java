package com.hans.evaluacionbcp.app.servicioseguridad.controller;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Change;
import com.hans.evaluacionbcp.app.servicioseguridad.model.response.ResponseChange;
import com.hans.evaluacionbcp.app.servicioseguridad.service.IChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(msj, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseChange, HttpStatus.OK);
    }

    @PostMapping("/updateChangeMoney")
    public ResponseEntity<?> updateChangeMoney(@RequestBody Change change) {
        Change changeResponse = changeService.updareChangeMoney(change);
        if (changeResponse == null) {
            String msj = "Moneda invalida";
            return new ResponseEntity<>(msj, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(changeResponse, HttpStatus.CREATED);
    }
}
