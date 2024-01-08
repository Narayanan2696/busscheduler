package com.apsrtc.busscheduler.controllers.security;

import com.apsrtc.busscheduler.services.DatabaseUserDetailsPasswordService;
import com.apsrtc.busscheduler.services.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

  @Autowired
  DatabaseUserDetailsService databaseUserDetailsService;
  @Autowired
  DatabaseUserDetailsPasswordService databaseUserDetailsPasswordService;
  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests((authorize) -> {
          authorize
              .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
              .requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")
              .requestMatchers(HttpMethod.POST, "/api/buses").hasAnyRole("ADMIN", "USER")
              .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
              .requestMatchers("/api/bus-schedules").permitAll()
              .requestMatchers("/api/users/registration").permitAll();
        })
        .userDetailsService(this.databaseUserDetailsService)
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }

}
