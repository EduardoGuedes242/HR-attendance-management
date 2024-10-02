package com.eduardoguedes.sistemaponto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "HR attendance management", version = "1", description = "System of control de employees"))
@SpringBootApplication
public class SistemapontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemapontoApplication.class, args);
	}

}
