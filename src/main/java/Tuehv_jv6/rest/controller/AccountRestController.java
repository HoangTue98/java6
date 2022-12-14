package Tuehv_jv6.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Tuehv_jv6.entity.Account;
import Tuehv_jv6.entity.Role;
import Tuehv_jv6.service.AccountService;
import Tuehv_jv6.service.RoleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping("check")
    public List<Account> checkAdmin(@RequestParam("admin")Optional<Boolean> admin){
        if (admin.orElse(false)){
            return accountService.getAdmin();
        }
        return accountService.findAll();
    }
    @GetMapping()
    public List<Account> getAll(@RequestParam("admin")Optional<Boolean> admin){
        return accountService.findAll();
    }
    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping("{username}")
    public Account getOne(@PathVariable("id")String id){
        return accountService.findById(id);
    }

    @PutMapping("{username}")
    public Account update(@PathVariable("username") String username,@RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable("username") String username) {
        accountService.delete(username);
    }
}
