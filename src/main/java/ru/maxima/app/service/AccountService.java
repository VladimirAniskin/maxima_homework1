package ru.maxima.app.service;

import ru.maxima.app.dto.AccountDto;
import ru.maxima.app.model.Account;

import java.util.List;

public interface AccountService {
    Account signUp(AccountDto dto);

    List<AccountDto> getAll();

    void register(AccountDto dto);


}
