package com.mnovak.fundsterapi.configuration;

import com.mnovak.fundsterapi.entity.User;
import com.mnovak.fundsterapi.enumeration.Role;
import com.mnovak.fundsterapi.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorization ->
                        authorization
                                .requestMatchers(HttpMethod.POST,"/api/users/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE,"/api/users/**").hasAnyAuthority(Role.ADMIN.name())
                                .requestMatchers("/api/users/**").hasAnyAuthority(Role.USER.name(),Role.ADMIN.name())
                                .requestMatchers(HttpMethod.DELETE, "/api/projects/**").hasAnyAuthority(Role.ADMIN.name())
                                .requestMatchers("/api/projects/**").hasAnyAuthority(Role.USER.name(),Role.ADMIN.name())
                                .anyRequest().authenticated()
                        )
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
