package com.algoship.okkyclone.modules.account.validator;

import com.algoship.okkyclone.modules.account.AccountRepository;
import com.algoship.okkyclone.modules.account.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/*
@Component : 빈으로 등록
@RequiredArgsConstructor : private final 변수의 생성자를 만
 */

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    // 스프링 4.x 버전 이후부터 SpringbootApplication 하단 모든 빈들은 따로 주입히지 않아도 자동 주입 되어 사용이 가능
    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        // 검사할 대상 SignUpForm으로 설정
        return aClass.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        SignUpForm signUpForm = (SignUpForm) object;
        System.out.println("check!"+object.toString());
        if (accountRepository.existsByEmail(signUpForm.getEmail())) {
            errors.rejectValue("email", "invalid.email", new Object[]{signUpForm.getEmail()}, "이미 사용중인 이메일입니다.");
        }

        if (accountRepository.existsByNickname(signUpForm.getNickname())) {
            errors.rejectValue("nickname", "invalid.nickname", new Object[]{signUpForm.getNickname()}, "이미 사용중인 닉네임입니다.");
        }
    }
}
