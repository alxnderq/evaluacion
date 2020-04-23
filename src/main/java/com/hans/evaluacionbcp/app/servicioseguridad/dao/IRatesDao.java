package com.hans.evaluacionbcp.app.servicioseguridad.dao;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Rates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rates")
public interface IRatesDao extends CrudRepository<Rates, Long> {

    @Query("select r from Rates r where r.currency.currencyBase = ?1 and r.rate = ?2")
    Rates findByCurrency(String currency, String rate);

}
