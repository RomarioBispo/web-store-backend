package br.com.codevelopment.token.security.config;


import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;

import br.com.codevelopment.common.property.JwtConfiguration;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter{
	
	protected final JwtConfiguration jwtConfiguration;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.exceptionHandling()
			.authenticationEntryPoint((req, resp, e ) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and()
		.authorizeRequests()
			.antMatchers(jwtConfiguration.getLoginUrl()).permitAll()
			.antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/user").permitAll()
			.antMatchers("/v1/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/auth/user/info").hasAnyRole("ADMIN", "USER")
			.anyRequest().authenticated();
	}
}
