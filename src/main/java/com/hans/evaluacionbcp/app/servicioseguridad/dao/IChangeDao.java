package com.hans.evaluacionbcp.app.servicioseguridad.dao;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Change;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "change")
public interface IChangeDao extends CrudRepository<Change, Long> {

    @Query("select u from Change u where u.descripcion=?1")
    Change findByDescripcion(String currency);
}
