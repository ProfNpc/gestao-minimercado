package com.belval.gestaominimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belval.gestaominimercado.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
