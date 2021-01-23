package com.algoship.okkyclone.modules.account;

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

    public boolean login(String username, String password) {
        Account account = accountRepository.findByEmail(username);
        return account.getPassword().equals(password);
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
