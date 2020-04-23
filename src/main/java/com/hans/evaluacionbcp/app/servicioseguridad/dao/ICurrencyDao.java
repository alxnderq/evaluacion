package com.hans.evaluacionbcp.app.servicioseguridad.dao;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency")
public interface ICurrencyDao extends CrudRepository<Currency, Long> {

    @Query("select c from Currency c where c.currencyBase=?1")
    Currency findByCurrencyBase(String currencyBase);

}
