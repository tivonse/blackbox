package com.tiv.lab.blackbox.config.security;

import com.tiv.lab.blackbox.security.handler.RedirectLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public RedirectLoginSuccessHandler redirectLoginSuccessHandler() {
//        return new RedirectLoginSuccessHandler();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CsrfTokenRepository cookieCsrfTokenRepository() {
//        return new CookieCsrfTokenRepository();
//    }
//
//    @Bean
//    public DataSource jdbcDataSource() {
//        return null;
//    }

//    @Bean
//    public UserDetailsService users() {
//        // The builder will ensure the passwords are encoded before saving in memory
//        User.UserBuilder users = User.builder();
//        UserDetails user = users
//                .username("user1")
//                .password("user1Pass")
//                .roles("USER")
//                .build();
//        UserDetails admin = users
//                .username("user2")
//                .password("user2Pass")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(new User.UserBuilder().passwordEncoder(passwordEncoder()).username("user1").password("user1Pass"));
//    }

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("user1Pass").roles("USER")
//                .and()
//                .withUser("user2").password("user2Pass").roles("USER", "ADMIN");
//    }

//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.
////                jdbcAuthentication()
////                .dataSource(jdbcDataSource())
////                .withDefaultSchema()
////                .withUser(User.withUsername("user3").password(passwordEncoder().encode("user3Pass")).roles("USER"));
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user1")
////                .password(passwordEncoder().encode("{bcrypt}$2y$04$YORA48MCz5towghjXZt0oeQn1IlPPZMlyp.JyaA2KygjKCncdhJ02")).roles("USER")
////                .and()
////                .withUser("user2")
////                .password("user2Pass").roles("USER", "ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin(Customizer.withDefaults());
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login*").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .permitAll()
//                .defaultSuccessUrl("/test.html", true)
////                .successHandler(redirectLoginSuccessHandler())
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/logout");
    }

}
