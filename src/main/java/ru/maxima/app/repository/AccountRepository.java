package ru.maxima.app.repository;

import ru.maxima.app.dto.AccountDto;
import ru.maxima.app.model.Account;

import java.util.List;

public interface AccountRepository {
    void signUp(Account account);
    List<Account> getAll();
}
