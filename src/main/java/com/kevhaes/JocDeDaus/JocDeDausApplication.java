package com.kevhaes.JocDeDaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JocDeDausApplication {

	public static void main(String[] args) {
		SpringApplication.run(JocDeDausApplication.class, args);
	}

//	@Configuration
//	static class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt();
//		}
//	}
}
