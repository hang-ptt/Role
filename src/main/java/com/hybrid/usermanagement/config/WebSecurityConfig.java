package com.hybrid.usermanagement.config;

import com.hybrid.usermanagement.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/cart").hasRole( "CUSTOMER")
                .antMatchers("/api").hasRole( "ADMIN")
                .antMatchers("/account").hasRole("CUSTOMER")
                .antMatchers("/add-to-cart").hasRole("CUSTOMER")
                .antMatchers("/payWithPaypal").hasRole("CUSTOMER")
                .antMatchers("/pay/success").hasRole("CUSTOMER")
                .antMatchers("/removeItem/**").hasRole("CUSTOMER")
                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/search/**").permitAll()
                .antMatchers("/detail/**").permitAll();
        http.authorizeRequests().and().formLogin()//
                .loginPage("/login")//
                .defaultSuccessUrl("/")//
                .failureUrl("/login?message=error")//
                .usernameParameter("username")//
                .passwordParameter("password")
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests()
                .antMatchers("/api/book/create/list").hasRole("ADMIN")
                .antMatchers("/api/book/get").hasRole("CUSTOMER")
                .antMatchers("/api/book/get/**").hasRole("ADMIN")
                .antMatchers("/api/signin").permitAll();
    }
}
