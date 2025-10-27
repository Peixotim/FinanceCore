package dev.peixotim.financecore.account.Service;

import dev.peixotim.financecore.account.DTOs.AccountRequest;
import dev.peixotim.financecore.account.DTOs.AccountResponse;
import dev.peixotim.financecore.account.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


   public AccountResponse createAccount(AccountRequest request){

   }
}
