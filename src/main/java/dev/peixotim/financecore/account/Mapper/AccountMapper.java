package dev.peixotim.financecore.account.Mapper;

import dev.peixotim.financecore.account.DTOs.AccountDTO;
import dev.peixotim.financecore.account.DTOs.AccountRequest;
import dev.peixotim.financecore.account.DTOs.AccountResponse;
import dev.peixotim.financecore.account.Entity.Account;
import dev.peixotim.financecore.exceptions.custom.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDTO toDTO(Account entity){
        AccountDTO dto = AccountDTO
                .builder()
                .id(entity.getId())
                .account_number(entity.getAccount_number())
                .balance(entity.getBalance())
                .user(entity.getUser())
                .build();
        return dto;
    }

    public Account toModel(AccountDTO dto){
        Account newModel = Account.
                builder()
                .id(dto.getId())
                .account_number(dto.getAccount_number())
                .balance(dto.getBalance())
                .user(dto.getUser())
                .build();

        return newModel;
    }

    public AccountResponse toResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .account_number(account.getAccount_number())
                .balance(account.getBalance())
                .userId(account.getUser().getId())
                .userName(account.getUser().getName())
                .userEmail(account.getUser().getEmail())
                .build();
    }

    public AccountRequest dtoToRequest(AccountDTO dto) {
        if(dto.getUser() == null || dto.getUser().getId() == null){
            throw new ResourceNotFoundException("User not found: cannot create or map account without a valid user reference.");
        }
        return AccountRequest.builder()
                .id(dto.getId())
                .account_number(dto.getAccount_number())
                .balance(dto.getBalance())
                .userId(dto.getUser().getId())
                .build();
    }


}
