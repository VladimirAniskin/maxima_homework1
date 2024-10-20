package ru.maxima.app.service;

import ru.maxima.app.dto.AccountDto;

import java.util.List;

public interface AccountService {
    void sigenUp (AccountDto dto);
    List <AccountDto> getAll();

}
