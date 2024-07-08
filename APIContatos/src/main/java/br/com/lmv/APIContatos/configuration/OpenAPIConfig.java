package br.com.lmv.APIContatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(
						new Info()
							.title("App de pessoas e seus telefones para contato")
							.description("Este app faz controle de cadastro de pessoas" + 
							             " bem como o cadastro e controle de contato.")
							.contact(new Contact()
										.name("Lucas Marques")
										.email("contatolucasmv@gmail.com")
										.url("http://localhost:8081")
									)
							.version("Versão 1.0.0-BETA")
						);
				
	}
	
}