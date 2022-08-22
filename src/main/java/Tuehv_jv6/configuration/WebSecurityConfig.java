package Tuehv_jv6.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Tuehv_jv6.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/admin/**","/assets/admin/**").hasAnyRole("Staff","Admin")
                .antMatchers("/rest/accounts/**","/rest/roles").hasRole("Admin")
                .antMatchers("/order/**").authenticated()
                .anyRequest().permitAll();
        httpSecurity.exceptionHandling().accessDeniedPage("/auth/unauthorized");

        httpSecurity
                .formLogin()
                .loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login") //submit form
                .defaultSuccessUrl("/auth/login/success",false) // co the chuyen huong toi url trc do
                .failureUrl("/auth/login/error") //dang nhap false thi chuyen huong toi day
                .usernameParameter("username")
                .passwordParameter("password");

        httpSecurity.rememberMe().rememberMeParameter("remember").tokenValiditySeconds(86400);

        httpSecurity
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/logout/success");
    }
}
