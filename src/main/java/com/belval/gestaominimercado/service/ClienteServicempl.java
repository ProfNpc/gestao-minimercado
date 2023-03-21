package com.belval.gestaominimercado.service;



import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.Role;
import com.belval.gestaominimercado.model.Cliente;
import com.belval.gestaominimercado.repository.ClienteRepository;
import com.belval.gestaominimercado.web.dto.ClienteDto;

@Service
public class ClienteServicempl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Cliente user = clienteRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
			                                                      user.getSenha(),
			                                                      mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public Cliente save(ClienteDto userDto) {
		
		Cliente user = new Cliente(userDto.getAniver(),
				userDto.getNome(),
				userDto.getEmail(),
				passwordEncoder.encode(userDto.getSenha()),
				userDto.getEndereco(),
				userDto.getCpf(),
				Arrays.asList(new Role("ROLE_USER")));
		
		
		return clienteRepository.save(user);
	}

	@Override
	public Cliente findByEmail(ClienteDto userDto) {
		return clienteRepository.findByEmail(userDto.getEmail());
	}

	@Override
	public Cliente update(Cliente user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
