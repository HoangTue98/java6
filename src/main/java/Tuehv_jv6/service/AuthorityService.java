package Tuehv_jv6.service;

import java.util.List;

import Tuehv_jv6.entity.Authority;

public interface AuthorityService {
    List<Authority> findAuthoritiesOfAdmin();

    List<Authority> findAll();

    Authority create(Authority authority);

    void delete(Integer id);
}
