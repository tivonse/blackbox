package com.tiv.lab.blackbox.config.security;

import com.tiv.lab.blackbox.security.handler.CustomSavedRequestAwareAuthenticationSuccessHandler;
import com.tiv.lab.blackbox.security.handler.RedirectLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${server.auth.login.redirect.url}")
    private String DEFAULT_TARGET_LOGIN_REDIRECT_URL = "";

    @Value("${server.auth.logout.redirect.url}")
    private String DEFAULT_TARGET_LOGOUT_REDIRECT_URL = "";

    @Autowired
    private DataSource dataSource;

    @Bean
    public RedirectLoginSuccessHandler redirectLoginSuccessHandler() {
        return new RedirectLoginSuccessHandler();
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler customSuccessRedirectHandler() {
        CustomSavedRequestAwareAuthenticationSuccessHandler successHandler = new CustomSavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter(DEFAULT_TARGET_LOGIN_REDIRECT_URL);
//        successHandler.setAlwaysUseDefaultTargetUrl(true);
        return successHandler;
    }

    @Bean
    public SimpleUrlLogoutSuccessHandler customSuccessLogoutHandler() {
        SimpleUrlLogoutSuccessHandler successLogoutHandler = new SimpleUrlLogoutSuccessHandler();
        successLogoutHandler.setTargetUrlParameter(DEFAULT_TARGET_LOGOUT_REDIRECT_URL);
        return successLogoutHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CsrfTokenRepository cookieCsrfTokenRepository() {
        return new CookieCsrfTokenRepository();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 1st approach to use jdbc authentication directly
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority FROM user_authorities a, users u WHERE u.username = ? AND u.user_id = a.user_id_fk");

        // 2nd approach to provide jdbc authentication handler manually in a customization
//        auth
//                .authenticationProvider();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login").permitAll()
                .successHandler(customSuccessRedirectHandler())
//                .successForwardUrl("/index")
//                .defaultSuccessUrl("/")
                .and()
                .logout().permitAll()
                .invalidateHttpSession(true)
                .logoutSuccessHandler(customSuccessLogoutHandler());
//                .successHandler(customSuccessRedirectHandler());
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
