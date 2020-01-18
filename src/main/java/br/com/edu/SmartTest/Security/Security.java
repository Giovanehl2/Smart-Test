package br.com.edu.SmartTest.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	/**
	 * método para delimitar as permições dos ususarios nas paginas
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/Alunos").permitAll().anyRequest()
				.authenticated().and().formLogin().permitAll();
	}

	/**
	 * metodo para fazer login em memoria apenas para teste
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// serve para decodificar a senha para não dar erro ao fazer o login
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("giovane").password(encoder.encode("250389")).roles("ADMIN");

	}

	/***
	 * método para evitar que spring bloqwueie o acesso aos arquivos css do projeto
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/style/**");
	}

}
