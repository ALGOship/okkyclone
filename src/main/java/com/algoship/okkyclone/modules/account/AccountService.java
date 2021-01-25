package com.algoship.okkyclone.modules.account;

import com.algoship.okkyclone.modules.account.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public void saveNewAccount(SignUpForm signUpForm) {

        Account account = Account.builder()
                .userId(signUpForm.getUserId())
                .email(signUpForm.getEmail())
                .name(signUpForm.getName())
                .nickname(signUpForm.getNickname())
                .password(signUpForm.getPassword())
                .build();

        accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserId(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        account.setPassword("{noop}" + account.getPassword());
        return new UserAccount(account);
    }
}
