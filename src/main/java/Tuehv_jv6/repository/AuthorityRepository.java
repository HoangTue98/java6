package Tuehv_jv6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tuehv_jv6.entity.Account;
import Tuehv_jv6.entity.Authority;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query("SELECT DISTINCT a from  Authority a where a.account in ?1")
    List<Authority> authorities(List<Account> accounts);
}
