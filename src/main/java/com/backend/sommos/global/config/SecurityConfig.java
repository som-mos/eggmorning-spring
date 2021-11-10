package com.backend.sommos.global.config;


import com.backend.sommos.domain.user.service.SomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SomUserDetailsService somUserDetailsService;

    @Autowired
    public SecurityConfig(SomUserDetailsService somUserDetailsService){
        this.somUserDetailsService = somUserDetailsService;
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 인증을 무시하기 위한 설정
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/**").permitAll() // 나머지 요청에 대해서는 로그인을 요구하지 않음
                    .and()
                .formLogin()     // 로그인하는 경우에 대해 설정함
                    .loginPage("/session")     // 로그인 페이지를 제공하는 URL을 설정함
                    .successForwardUrl("/session")    // 로그인 성공 URL을 설정함
                    .failureForwardUrl("/session")    // 로그인 실패 URL을 설정함
//                  .defaultSuccessUrl("/")      // 로그인 성공 시 이동할 페이지
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)    // 세션 초기화
                    .and()
                .exceptionHandling();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 로그인 처리를 하기 위한 AuthenticationManagerBuilder를 설정
        auth.userDetailsService(somUserDetailsService).passwordEncoder(passwordEncoder());

        //localDB에 연결 설정
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                // Authentication 인증이라고 불리며 로그인처리 한다.
                .usersByUsernameQuery("select username, password, enabled from user "
                    +"where username = ?");
                // Authroization 권한 설정
//                .authoritiesByUsernameQuery("select username, name from  "
//                    +"");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
