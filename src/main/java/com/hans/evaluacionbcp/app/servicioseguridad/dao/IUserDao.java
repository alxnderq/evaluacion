package com.hans.evaluacionbcp.app.servicioseguridad.dao;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(path = "user")
public interface IUserDao extends CrudRepository<Usuario, Long> {

    @Transactional(readOnly = true)
    @Query("select u from Usuario u where u.username=?1")
    Usuario findByUsername(String username);
}
