package br.com.codevelopment.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.codevelopment.microservices.common.domain.model.ApplicationUser;
import br.com.codevelopment.microservices.common.repository.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class AuthApplication implements CommandLineRunner{
	@Autowired
	private ApplicationUserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public static void main(String[] args)  {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	/**
	 * Cria usuario admin para teste da api
	 */
	@Override
	public void run(String... args) throws Exception {
		if (repository.findByusername("romario") == null) {
			ApplicationUser user = new ApplicationUser();
			user.setUsername("romario");
			user.setRole("ADMIN");
			user.setPassword(encoder.encode("root"));
			log.debug("user credentials for tests: {}", repository.save(user));
		}
	}

}
