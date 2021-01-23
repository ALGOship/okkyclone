package com.algoship.okkyclone.modules.account.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// 클라이언트에서도 입력 체크가 가능하지만 자바스크립트 문법을 통해 회피가 가능하기 때문에 서버에서 한번에 해준다

@Data
public class SignUpForm {

    @NotBlank
    @Length(min = 1, max = 20)
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{1,20}$")
    private String nickname;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8, max = 50)
    private String password;

}
