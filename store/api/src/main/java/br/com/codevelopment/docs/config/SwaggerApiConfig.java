package br.com.codevelopment.docs.config;

import org.springframework.context.annotation.Configuration;

import br.com.codevelopment.common.docs.BaseSwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApiConfig extends BaseSwaggerConfig{

	public SwaggerApiConfig() {
		super("br.com.codevelopment.api");
	}
}
