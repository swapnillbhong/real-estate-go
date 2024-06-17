//package com.example.realestatego.appsecurityconfig;
////Import necessary packages
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import com.example.realestatego.service.impl.UserDetailService;
//
////Configuration annotation to mark this class as a configuration class
//@Configuration
//
////EnableWebSecurity annotation to enable Spring Security's web security support
//@EnableWebSecurity
//
////EnableMethodSecurity annotation to enable Spring Security's method security support
//@EnableMethodSecurity
//public class AppSecurityConfig {
//
// // Bean for providing custom UserDetailsService
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailService();
//	}
//
// // Bean for providing BCryptPasswordEncoder for password encoding
//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//
// // Bean for providing AuthenticationProvider using DaoAuthenticationProvider
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService());
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
//
// // Bean for providing AuthenticationManager
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//			throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}
//
// // Bean for configuring SecurityFilterChain
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     // Configuring security rules and permissions
//		http.csrf().disable().authorizeHttpRequests()
//				.requestMatchers("/addadmin","/agent/viewall","/agent/{agentId}","/customer/**")
//				.permitAll().and().authorizeHttpRequests()
//				.requestMatchers(HttpMethod.POST, "/agent/add").hasAnyAuthority("Admin")
//				.requestMatchers(HttpMethod.POST, "/propertyAdd").hasAnyAuthority("Agent")
//				.requestMatchers(HttpMethod.GET, "/propertyList").hasAnyAuthority("Customer")
//				.requestMatchers(HttpMethod.POST, "/appointment/addp").hasAnyAuthority("Customer")
//				.requestMatchers(HttpMethod.GET, "/appointment/{appointmentId}").hasAnyAuthority("Agent")
//				.requestMatchers(HttpMethod.POST, "/reviews").hasAnyAuthority("Customer")
//				.requestMatchers(HttpMethod.POST, "/reviews/{reviewId}").hasAnyAuthority("Customer")
//				.requestMatchers(HttpMethod.GET, "/reviews/view").hasAnyAuthority("Customer")
//				.requestMatchers(HttpMethod.GET, "/listAppointments").hasAnyAuthority("Agent")
//				.requestMatchers(HttpMethod.GET, "/property/name/{propertyName}").hasAnyAuthority("Agent")
//				.requestMatchers(HttpMethod.GET, "/property/city/{propertyCity}").hasAnyAuthority("Customer")
//				.anyRequest().authenticated().and().formLogin().permitAll().and().httpBasic();
//
//		return http.build();
//	}
//}
