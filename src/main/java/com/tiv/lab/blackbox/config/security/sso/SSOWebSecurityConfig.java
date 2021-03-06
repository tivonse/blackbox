package com.tiv.lab.blackbox.config.security.sso;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;

@EnableWebSecurity
@Configuration
@Order(2)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SSOWebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers(GET, "/home").permitAll()
//                .antMatchers(GET, "/api/samlLink").permitAll()
//                .antMatchers("/**").authenticated()
//                .and()
//                .formLogin().loginPage("/home");
//
//        http.csrf().disable();
//        http.headers().cacheControl().disable();
//    }

}
