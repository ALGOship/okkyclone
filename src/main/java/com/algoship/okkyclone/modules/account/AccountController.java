package com.algoship.okkyclone.modules.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AccountController {

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        return "login";
    }

//    @PostMapping("/sign-up")
//    public String signUpSubmit(Model model) {
//        return "login";
//    }

    @GetMapping("/register")
    public String register(@RequestBody Account account) {
        return "register";
    }

    @GetMapping("/sign-out")
    public String logout() {
        return "home";
    }
}
