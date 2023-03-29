package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class PersonalWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    //authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authentication = auth.inMemoryAuthentication()
//        auth.authenticationProvider(authenticationProvider());
//        auth.userDetailsService();
        auth.inMemoryAuthentication().withUser("ian").password("{noop}1234").authorities("ADMIN_API");
        auth.inMemoryAuthentication().withUser("ken").password("{noop}crystal").authorities("EMPLOYEE_API");
        auth.inMemoryAuthentication().withUser("timon").password("{noop}crystal").authorities("STUDENT_API");
    }

    //noop meaning no need for encoding password since it's being stored in the RAM
    //authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/home").permitAll()
                .antMatchers("/v1/welcome").authenticated()
                .antMatchers("/v1/admin").hasAuthority("ADMIN_API")
                .antMatchers("/v1/employee").hasAuthority("EMPLOYEE_API")
                .antMatchers("/v1/student").hasAuthority("STUDENT_API")
                .antMatchers("/v1/common").hasAnyAuthority(new String[]{"ADMIN_API", "EMPLOYEE_API", "STUDENT_API"})
                .anyRequest().denyAll()
                //the above is for all other requests that have not been covered above
//               about the login form
                .and().
                formLogin()
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login")
                .successForwardUrl("/welcome")
//               about the logout form
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .logoutUrl("/logout")
                .clearAuthentication(true).permitAll()
                //about exceptions encountered during logout and login
                .and()
                .exceptionHandling()
                .accessDeniedPage("/denied")
                .and().csrf().disable();
    }
    @Bean
    public PasswordEncoder myPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
