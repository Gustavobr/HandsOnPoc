package br.com.poc.configuration;

import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@org.springframework.context.annotation.Configuration
@Profile("{dev,uat}")
@Component
public class Configuration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean

	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Producttore API")
				.description("A Product Store project implemented with Spring Boot and Java 17.")
				.contact(new Contact().name("GustavoScipiao@gmail.com").url("https://github.com/gustavobr")));

	}
	
	
	
	@Bean
	public GroupedOpenApi customOpenDoc() {
		return GroupedOpenApi.builder()
					.group("api")
					.pathsToMatch("/api/**")
					.build();
	}
}
