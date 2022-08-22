package Tuehv_jv6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tuehv_jv6.entity.Account;
import Tuehv_jv6.repository.AccountRepository;
import Tuehv_jv6.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).get();
    }

    @Override
    public List<Account> getAdmin() {
        return accountRepository.getAdmin();
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(String username) {
        accountRepository.deleteById(username);
    }
}
