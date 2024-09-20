package com.application.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Usuario;
import com.application.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<?> principal(){
        return ResponseEntity.ok("Hola");
    }

    @GetMapping("/local")
    public ResponseEntity<?> principal2(){
        return ResponseEntity.ok("Hola2");
    }
    @PostMapping("/create")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) throws URISyntaxException{
        if (usuario.getRoles().isEmpty() || usuario.getRoles().size() == 0) {
            throw new RuntimeException("No se puede crear un usuario sin roles");
        }
        usuarioService.crearUsuario(usuario);

        return ResponseEntity.created(new URI("/api/create")).body(usuario);
    }   
}
