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

    private final SignUpFormValidator signUpFormValidator;

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

        // 가입 완료
        return "redirect:/";
    }

    @GetMapping("/sign-out")
    public String logout() {
        return "home";
    }
}
