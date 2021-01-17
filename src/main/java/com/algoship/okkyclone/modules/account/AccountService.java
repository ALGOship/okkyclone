package com.algoship.okkyclone.modules.account;

import org.springframework.stereotype.Service;

@Service
public class AccountService{

    private AccountRepository accountRepository;

    public Account login(Account account) {
        accountRepository.save(account);
        return account;
    }
}
