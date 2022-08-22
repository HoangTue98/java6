package Tuehv_jv6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tuehv_jv6.entity.Account;
import Tuehv_jv6.entity.Authority;
import Tuehv_jv6.repository.AccountRepository;
import Tuehv_jv6.repository.AuthorityRepository;
import Tuehv_jv6.service.AuthorityService;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Authority> findAuthoritiesOfAdmin() {
        List<Account> accounts = accountRepository.getAdmin();
        return authorityRepository.authorities(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void delete(Integer id) {
        authorityRepository.deleteById(id);
    }
}
