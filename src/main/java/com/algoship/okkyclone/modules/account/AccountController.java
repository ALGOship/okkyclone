package com.algoship.okkyclone.modules.account;

import com.algoship.okkyclone.modules.account.form.SignUpForm;
import com.algoship.okkyclone.modules.account.validator.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class AccountController {

    // 왜 무조건 final로 해야하는가??
    private final SignUpFormValidator signUpFormValidator;
    private final AccountRepository accountRepository;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        return "login";
    }
  
    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "sign-up";
        }
        
        Account account = Account.builder()
                .userId(signUpForm.getUserId())
                .email(signUpForm.getEmail())
                .name(signUpForm.getName())
                .nickname(signUpForm.getNickname())
                .password(signUpForm.getPassword())
                .build();

        accountRepository.save(account);

        // 가입 완료
        return "redirect:/";
    }

    @GetMapping("/sign-out")
    public String logout() {
        return "home";
    }
}
