package Tuehv_jv6.service;

import java.util.List;

import Tuehv_jv6.entity.Account;

public interface AccountService {
    public Account findById(String username);

    List<Account> getAdmin();

    List<Account> findAll();

    Account create(Account account);

    Account update(Account account);

    void delete(String username);

}
