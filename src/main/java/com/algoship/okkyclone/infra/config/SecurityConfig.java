package com.algoship.okkyclone.infra.config;

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
                                    "/static/**",
                                    "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 아래의 모든 설정 http.and()를 통해 한번에 묶을 수 있음

        // 모든 사용자가 접근 가능한 경로 설정
        http.authorizeRequests()
                .mvcMatchers("/", "/home", "/user/**").permitAll();

        // security 에서 post 요청은 보안을 위해 csrf 토큰을 사용함. 나중에 설정하고 일단 비활성화 시킴
        http.csrf().disable();


        // 커스텀한 로그인 페이지를 스프링 시큐리티 로그인 창으로 보여줌
        http.formLogin()
                .loginPage("/user/sign-in")      // 커스텀 로그인 페이지 설정
                .failureUrl("/user/sign-in")            // 로그인 실패 시 이동할 페이지 설정
                .defaultSuccessUrl("/")     // 로그인 성공 시 이동할 페이지 설정
                .permitAll();

        // 로그아웃 했을 때 어디로 이동할 지 설정
        http.logout()
                .logoutSuccessUrl("/");
    }
}