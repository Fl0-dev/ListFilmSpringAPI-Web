package com.mycompany.dvdstore;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

	//lancement de l'application
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	//permet d'instancier le module qui permet de ne pas chercher trop
	//loin dans les jointures lors de l'affichage d'une entity
	@Bean
	public Hibernate5Module datatypeHibernateModule() {
		return new Hibernate5Module();
	}
}
