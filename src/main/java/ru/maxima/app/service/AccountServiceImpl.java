package ru.maxima.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.app.dto.AccountDto;
import ru.maxima.app.model.Account;
import ru.maxima.app.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.maxima.app.model.Account.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private AccountRepository accountRepository;

    @Override
    public void sigenUp(AccountDto dto) {
        accountRepository.signUp(Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
    }


    @Override
    public List<AccountDto> getAll() {
        List <Account> accounts = accountRepository.getAll();

        return accounts.stream().map(acc->AccountDto.builder().build() ).collect(Collectors.toList());
    }
}
