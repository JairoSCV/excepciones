package com.application;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.entity.Rol;
import com.application.entity.RoleEnum;
import com.application.entity.Usuario;
import com.application.repository.UsuarioRepository;

@SpringBootApplication
public class SpringSecurityMineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMineApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UsuarioRepository userRepository) {
        return args -> {
			Rol roleAdmin = Rol.builder()
				.name(RoleEnum.ADMIN)
				.build();
                    
			Rol roleAdmin2 = Rol.builder()
			.name(RoleEnum.USER)
			.build();
					
			Rol roleAdmin3 = Rol.builder()
			.name(RoleEnum.GUEST)
			.build();

			Usuario usuario = Usuario.builder()
				.username("cronaldo")
				.password("$2a$10$aXL4zORYThXI0N/k6U5yeeONtoFgLS5yXIjaGXX0t0NX6WQebxOoe")
				.roles(Set.of(roleAdmin))
				.build();

			Usuario usuario2 = Usuario.builder()
				.username("lmessi")
				.password("$2a$10$aXL4zORYThXI0N/k6U5yeeONtoFgLS5yXIjaGXX0t0NX6WQebxOoe")
				.roles(Set.of(roleAdmin2))
				.build();

			userRepository.saveAll(List.of(usuario, usuario2));
		};
	}

}
