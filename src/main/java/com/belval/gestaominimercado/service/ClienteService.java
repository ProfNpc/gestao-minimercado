package com.belval.gestaominimercado.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Service
public interface ClienteService extends UserDetailsService {
	Cliente save(ClienteDto userDto);
	Cliente findByEmail(ClienteDto userDto);
	Cliente update(Cliente user);
}
