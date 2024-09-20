package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    public Usuario findUsuarioByUsername(String username);
}
