package com.myblog.myblog11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//after adding this @PreAuthorize annotation can be used
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override

    protected void configure(HttpSecurity http) throws Exception{//create new object and address is present in Http
        http                                //writing the code in chaining format
                .csrf().disable()
                .authorizeRequests()
               // antMatchers is used to provide access to the url
                .antMatchers(HttpMethod.GET,"/api/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();//one of the different type of authentication
    }
 @Override
    @Bean
    //this particular method is responsible for storing username and password using builder()
    protected UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder().username("pankaj").password(passwordEncoder()
                .encode("password")).roles("USER").build();
        UserDetails user2 = User.builder().username("admin").password(passwordEncoder()
                .encode("admin")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1,user2);
        //creating inMemory object where we store username and password
    }
}
