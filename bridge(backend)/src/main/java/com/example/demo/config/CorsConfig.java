package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CorsConfig implements WebMvcConfigurer {
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        // Autoriser toutes les origines (vous pouvez restreindre à des origines spécifiques)
	        registry.addMapping("/api/**")
	                .allowedOrigins("http://localhost:4200")  // L'URL de votre front-end Angular
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes autorisées
	                .allowedHeaders("*")  // Autoriser tous les en-têtes
	                .allowCredentials(true);  // Autoriser les cookies si nécessaire
	    }
	}


