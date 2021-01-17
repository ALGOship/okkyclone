package com.algoship.okkyclone.infra.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 스프링 시큐리티가 login 창으로 post 요청이 오면 따로 컨트롤러를 만들어줄 필요 없이 처리해준다.
 *
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("/", "/home", "/sign-up").permitAll()
//                .anyRequest().authenticated();

        // 커스텀한 로그인 페이지를 스프링 시큐리티 로그인 창으로 보여줌
//        http.formLogin()
//                .loginPage("/sign-up");

        // 로그아웃 했을 때 어디로 이동할 지 설정
//       http.logout()
//                .logoutSuccessUrl("/");
    }
}
