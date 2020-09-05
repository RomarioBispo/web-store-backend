package br.com.codevelopment.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.codevelopment.common.property.JwtConfiguration;
import br.com.codevelopment.token.converter.TokenConverter;
import br.com.codevelopment.token.security.JwtTokenAuthorizationFilter;
import br.com.codevelopment.token.security.config.SecurityTokenConfig;

@EnableWebSecurity
public class SecurityConfig extends SecurityTokenConfig{
	
	private TokenConverter tokenConverter;
	
	public SecurityConfig(JwtConfiguration jwtConfiguration,
			TokenConverter tokenConverter) {
		super(jwtConfiguration);
		this.tokenConverter = tokenConverter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration,
			tokenConverter), UsernamePasswordAuthenticationFilter.class);
	super.configure(http);
	}
}
