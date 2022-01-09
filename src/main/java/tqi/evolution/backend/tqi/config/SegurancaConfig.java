package tqi.evolution.backend.tqi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SegurancaConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.httpBasic()
//        .and()
//        .authorizeRequests()
//        .antMatchers("/h2-console/**").permitAll()
////		.and()
////		.authorizeRequests()
////		.anyRequest()
////		.authenticated()
//		.sessionManagement()
		
//		http
//		.httpBasic()
//		.and()
//		.authorizeHttpRequests()
//		.authorizeRequests().antMatchers("/**").hasAnyRole()
//		.and()
//		.authorizeRequests().antMatchers("/h2-console/**").permitAll()
//		.and()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.inMemoryAuthentication()
//	        .withUser("anderson").password("{noop}123").roles("ADMIN")
//	    .and()
//	    	.withUser("admin").password("admin").roles("ADMIN")
//	    	;
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}
//	// https://www.youtube.com/watch?v=_NKOajmVNZw
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
////			.withUser("anderson").password("123").roles("ADMIN")
////			.and()
//			.withUser("admin").password("admin").roles("ADMIN")
//		;
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.sessionManagement()
//			.sessionCreationPolicy(SessionCreationPolicy.NEVER)
//		;
//	}
//
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}