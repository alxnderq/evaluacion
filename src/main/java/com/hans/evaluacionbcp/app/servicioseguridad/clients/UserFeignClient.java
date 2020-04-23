package com.hans.evaluacionbcp.app.servicioseguridad.clients;

import com.hans.evaluacionbcp.app.servicioseguridad.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="servicio-usuarios")
public interface UserFeignClient {

	@GetMapping("/usuarios/search/load-username")
	Usuario findByUsername(@RequestParam String username);
}
