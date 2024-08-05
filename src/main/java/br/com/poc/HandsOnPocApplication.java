package br.com.poc;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.poc.entity.Mensagem;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
//@ComponentScan(basePackageClasses = br.com.poc.configuration.Configuration.class)

public class HandsOnPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsOnPocApplication.class, args);
	}

	/*
	@Bean

	public CommandLineRunner sendMessage(RabbitTemplate template) {
		return args -> {
			template.convertAndSend("fila-exemplo", new Mensagem("Hello rabbitMQ"));
			System.out.println("Mensagem Enviada");
		};
	}
	*/

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
		return new OpenAPI().info(new Info().title("ProductStore API")
				.description("A Product Store project implemented with Spring Boot and Java 17.")
				.contact(new Contact().name("GustavoScipiao@gmail.com").url("https://github.com/gustavobr")));

	}

}
