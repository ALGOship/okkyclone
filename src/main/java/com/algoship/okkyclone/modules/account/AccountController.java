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

    // 싱글톤으로 사용하려고 final 선언함
    private final AccountService accountService;
    private final SignUpFormValidator signUpFormValidator;
    private final AccountRepository accountRepository;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-in")
    public String signUpForm() {
        return "/login";
    }

    @PostMapping("/sign-in")
    public String signUpSubmit(@RequestBody String username, String password) {
        System.out.println("input info : "+ username + ","+password);
        return "redirect:/";
    }

    @GetMapping("/success")
    public String signUpSuccess() {
        return "login-success";
    }
  
    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "sign-up";
        }
        // 가입 완료
        accountService.saveNewAccount(signUpForm);
        return "redirect:/";
    }

    @GetMapping("/sign-out")
    public String logout() {
        return "/";
    }
}
