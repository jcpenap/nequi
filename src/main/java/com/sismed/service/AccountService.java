package com.sismed.service;

import com.sismed.domain.Account;
import com.sismed.request.AccountRequest;
import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account create(AccountRequest request);

    Account withdraw(Long id, AccountRequest request);

    Account deposit(Long id, AccountRequest request);

    void delete(Long id);
}
