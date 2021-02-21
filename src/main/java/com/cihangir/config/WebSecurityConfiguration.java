package com.cihangir.config;

import com.cihangir.security.MySimpleUrlAuthenticationSuccessHandler;
import com.cihangir.security.MyUserDetailsService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private final MyUserDetailsService userDetailsService;

  private final AuthenticationManagerBuilder authenticationManagerBuilder;

  public WebSecurityConfiguration(MyUserDetailsService userDetailsService,
      AuthenticationManagerBuilder authenticationManagerBuilder) {
    this.userDetailsService = userDetailsService;
    this.authenticationManagerBuilder = authenticationManagerBuilder;
  }


  @PostConstruct
  public void init() {
    try {
      authenticationManagerBuilder
          .userDetailsService(userDetailsService);
    } catch (Exception e) {
      throw new BeanInitializationException("Security configuration failed", e);
    }
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.headers().frameOptions().disable();

    http.
    authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/showCreateNewUser").permitAll()
        .antMatchers("/saveNewUser").permitAll()
        .antMatchers("/company/**").hasAuthority("COMPANY_USER")
        .antMatchers("/applicant/**").hasAuthority("USER")
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest()
        .authenticated().and().csrf().disable()
        .formLogin()
        .loginPage("/login").failureUrl("/login?error=true")
        .successHandler(myAuthenticationSuccessHandler())
        .usernameParameter("username")
        .passwordParameter("password")
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login").and().exceptionHandling()
        .accessDeniedPage("/access-denied");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
  }

  @Bean
  public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
    return new MySimpleUrlAuthenticationSuccessHandler();
  }

}