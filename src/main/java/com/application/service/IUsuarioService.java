package com.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.application.entity.Usuario;

public interface IUsuarioService extends UserDetailsService{
    public Usuario crearUsuario(Usuario usuario);
}
