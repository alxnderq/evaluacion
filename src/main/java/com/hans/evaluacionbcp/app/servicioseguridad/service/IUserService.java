package com.hans.evaluacionbcp.app.servicioseguridad.service;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Usuario;

public interface IUserService {
    Usuario findByUsername(String username);
}
