package br.com.codevelopment.common.docs;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class BaseSwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.codevelopment"))
		.build()
		.apiInfo(metadata());
	}
	
	private ApiInfo metadata() {
		return new ApiInfoBuilder().
				title("Microservices API")
				.description("A simple API using microservices architecture")
				.contact(new Contact("codevelopment", "codevelopment.com.br", null))
				.license("This project was made on spring boot microservices course by devdojo at youtube")
				.build();
	}
}
