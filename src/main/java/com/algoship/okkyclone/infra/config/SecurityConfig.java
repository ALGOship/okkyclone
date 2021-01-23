package com.algoship.okkyclone.infra.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 리소스를 권한 없이 모든 사용자에게 접근 가능하도록 설정
        web.ignoring().antMatchers("/resources/**",
                                    "/css/**",
                                    "/images/**",
                                    "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 모든 사용자가 접근 가능한 경로 설정
        http.authorizeRequests()
                .mvcMatchers("/", "/home", "/user/**").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();


        // 커스텀한 로그인 페이지를 스프링 시큐리티 로그인 창으로 보여줌
//        http.formLogin()
//                .loginPage("/sign-up");

        // 로그아웃 했을 때 어디로 이동할 지 설정
        http.logout()
                .logoutSuccessUrl("/");
    }
}