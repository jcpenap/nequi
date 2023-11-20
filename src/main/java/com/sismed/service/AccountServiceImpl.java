package com.sismed.service;

import com.sismed.domain.Account;
import com.sismed.repository.AccountRepository;
import com.sismed.request.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(AccountRequest request) {
        Account account = new Account();
        account.setStatus(true);
        account.setBalance(request.getMoney());
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(Long id, AccountRequest request) {
        Account account = accountRepository.findById(id).get();
        account.setBalance(account.getBalance() - request.getMoney());
        return accountRepository.save(account);
    }

    @Override
    public Account deposit(Long id, AccountRequest request) {
        Account account = accountRepository.findById(id).get();
        account.setBalance(account.getBalance() + request.getMoney());
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

}
