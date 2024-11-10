package ru.maxima.app.repository;

import ru.maxima.app.model.Account;

import java.util.List;

public interface AccountRepository {
    Account signUp(Account account);

    List<Account> getAll();

    void register(Account account);
}
