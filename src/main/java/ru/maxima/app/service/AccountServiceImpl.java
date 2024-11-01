package ru.maxima.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.app.dto.AccountDto;
import ru.maxima.app.model.Account;
import ru.maxima.app.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account sigenUp(AccountDto dto) {

        accountRepository.signUp(Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
        return null;
    }


    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.getAll();

        return accounts.stream().map(acc -> AccountDto.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .email(acc.getEmail())
                .password(acc.getPassword())
                .build()).collect(Collectors.toList());
    }
    public void register(AccountDto dto) {
        accountRepository.register(Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .build());
    }
}
