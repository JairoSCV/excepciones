package com.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.entity.Rol;
import com.application.entity.RoleEnum;

public interface RolRepository extends CrudRepository<Rol, Long>{
    public Rol findRolByName(RoleEnum nombre);
}
